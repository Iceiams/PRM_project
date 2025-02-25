package com.example.asm_dam.Activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.asm1_ps09755.R;
import com.example.asm_dam.SQL_ASM.UsersDAO;

import java.util.Objects;


public class NguoiDungDetailActivity extends AppCompatActivity {
    EditText edFullName, edPhone;
    UsersDAO nguoiDungDAO;
    String username, fullname, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoi_dung_detail);
        edFullName = findViewById(R.id.edFullName);
        edPhone = findViewById(R.id.edPhone);;
        nguoiDungDAO = new UsersDAO(this);

        Intent intent = getIntent();
        Bundle b = intent.getBundleExtra("dulieu");


        fullname = b.getString("FULLNAME");
        phone = b.getString("PHONE");

        edFullName.setText(fullname);
        edPhone.setText(phone);
    }

    public void updateUser(View view) {
        if (nguoiDungDAO.updateInfoNguoiDung(username, edPhone.getText().toString(), edFullName.getText().toString()) > 0) {
            Toast.makeText(getApplicationContext(), "Lưu thành công", Toast.LENGTH_SHORT).show();
        }
    }

    public void Huy(View view) {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}