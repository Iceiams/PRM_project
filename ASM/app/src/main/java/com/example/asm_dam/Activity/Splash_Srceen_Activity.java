package com.example.asm_dam.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.asm1_ps09755.R;

public class Splash_Srceen_Activity extends AppCompatActivity {
    private ImageView ivs;
    private ProgressBar progressBar ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__srceen);
//        ivs= findViewById(R.id.ivs);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.anima) ;
//        ivs.startAnimation(myanim);
        final Intent i = new Intent(this, dangki.class);
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(6000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();

                }
            }
        };
        timer.start();
    }
}

