package com.example.asm_dam.Activity;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.asm1_ps09755.R;
import com.example.asm_dam.SQL_ASM.UsersDAO;
import com.example.asm_dam.model.Usermodel;

public class ChangePassActivity extends AppCompatActivity {
    EditText edPasss, edRePasss, edTennguoidung;
    UsersDAO nguoiDungDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("CHANGE PASSWORD");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_change_password);
        edPasss = findViewById(R.id.edPassword);
        edRePasss = findViewById(R.id.edRePassword);
        edTennguoidung = findViewById(R.id.edTennguoidung);

    }

    public int validateFor() {
        int check = 1;
        if (edPasss.getText().length() == 0 || edRePasss.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "Bạn phải nhập đầy đủ thông tin ",
                    Toast.LENGTH_SHORT).show();
            check = -1;
        } else {
            String rePass = edRePasss.getText().toString();
            String pass = edPasss.getText().toString();
            if (!pass.equals(rePass)) {
                Toast.makeText(getApplicationContext(), "Mật khẩu không trùng khớp",
                        Toast.LENGTH_SHORT).show();
                check = -1;
            }
        }
        return check;
    }

    public void changePassword(View view) {
        SharedPreferences pref = getSharedPreferences("USER_FILE", MODE_PRIVATE);
        nguoiDungDAO = new UsersDAO(ChangePassActivity.this);
        Usermodel user = new Usermodel(edTennguoidung.getText().toString(), edPasss.getText().toString(), "", "");
        try {
            if (validateFor() > 0) {
                if (nguoiDungDAO.changePasswordNguoiDung(user) > 0) {
                    Toast.makeText(getApplicationContext(), "Cập nhật mật khẩu thành công",
                            Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Sai tên tài khoản",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        } catch (Exception ex) {
            Log.e("Error", ex.toString());
        }
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
