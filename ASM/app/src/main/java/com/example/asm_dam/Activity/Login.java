package com.example.asm_dam.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.asm1_ps09755.R;
import com.example.asm_dam.SQL_ASM.Database;
import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {
    TextInputEditText email_log, pass_log;
    TextView link_dk;
    AppCompatButton login;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new Database(this);
        email_log = findViewById(R.id.email11);
        pass_log = findViewById(R.id.password11);
        login = findViewById(R.id.btn_login);
        link_dk = findViewById(R.id.link_signup);
//        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.anima) ;
        Animation myanim = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fadeout);
       login.startAnimation(myanim);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = email_log.getText().toString();
                String password = pass_log.getText().toString();
                if(email.length()<4 ){
                    Toast.makeText(getApplicationContext(), "Username must be at least 4 charter", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password must be at least 6 characters long", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!email.matches("[a-zA-Z0-9]*")) {
                    Toast.makeText(getApplicationContext(), "Username must not contain special characters", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]*$")) {
                    Toast.makeText(getApplicationContext(), "Password must contain both letters and numbers", Toast.LENGTH_SHORT).show();
                    return;
                }
                Boolean checkemailpassword = db.checkmailpass(email,password);
                if(checkemailpassword == true){
                    Intent i = new Intent(Login.this, Home.class);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(),"Please Check Your UserName or Password Again",Toast.LENGTH_SHORT).show();
                }

            }
        });

        link_dk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, dangki.class);
                startActivity(i);
            }
        });
    }
}
