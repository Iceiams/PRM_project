package com.example.asm_dam.Activity;

import android.graphics.Typeface;
import android.os.Bundle;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.asm1_ps09755.R;
import com.example.asm_dam.SQL_ASM.UsersDAO;
import com.example.asm_dam.model.Usermodel;


public class ThemNguoiDungActivity extends AppCompatActivity {
    Button btnThemNguoiDung;
    UsersDAO nguoiDungDAO;
    EditText edUser, edPass, edRePass, edPhone, edFullName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("ADD USER");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_add__user);
        btnThemNguoiDung = findViewById(R.id.btnAddUser);
        edUser = findViewById(R.id.edUser);
        edPass = findViewById(R.id.edPass);
        edPhone = findViewById(R.id.edPhone);
        edFullName = findViewById(R.id.edFullName);
        edRePass = findViewById(R.id.edRePass);

    }

    public void showUsers(View view) {
        finish();
    }

    public void quaylai(View view) {
        onBackPressed();
    }

    public void addUser(View view) {
        nguoiDungDAO = new UsersDAO(ThemNguoiDungActivity.this);
        Usermodel user = new Usermodel(edUser.getText().toString(), edPass.getText().toString(), edPhone.getText().toString(), edFullName.getText().toString());
        try {
            if (validateForm() > 0) {
                if (nguoiDungDAO.inserUser(user) > 0) {
                    Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception ex) {
            Log.e("Lỗi:", ex.toString());
        }
    }

    public int validateForm() {
        int check = 1;
        if (edUser.getText().length() == 0 || edFullName.getText().length() == 0
                || edPhone.getText().length() == 0 || edPass.getText().length() == 0
                || edRePass.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "Bạn phải nhập đầy đủ thông tin ",
                    Toast.LENGTH_SHORT).show();
            check = -1;
        } else {
            String pass = edPass.getText().toString();
            String rePass = edRePass.getText().toString();
            if (!pass.equals(rePass)) {
                Toast.makeText(getApplicationContext(), "Mật khẩu không trùng khớp",
                        Toast.LENGTH_SHORT).show();
                check = -1;
            }
        }
        return check;
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
