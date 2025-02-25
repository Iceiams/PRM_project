package com.example.asm_dam.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.asm1_ps09755.R;
import com.example.asm_dam.SQL_ASM.BookDAO;

public class SachDetailActivity extends AppCompatActivity {
    EditText maSach, tenSach, tacgia, nxb, giaban, soluong;
    BookDAO sachDAO;
    Spinner spnTheLoaisua;
    String masua, tensua, tacsua, nxbsua, giasua, sosua,  maSachk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("BOOK DETAILS");

        setContentView(R.layout.activity_sachdetail);
        tenSach = findViewById(R.id.edTenSachsua);
        maSach = findViewById(R.id.edMaSachsua);
        tacgia = findViewById(R.id.edTacGiasua);
        nxb = findViewById(R.id.edNXBsua);
        giaban = findViewById(R.id.edGiaBiasua);
        soluong = findViewById(R.id.edSoLuongsua);

        sachDAO = new BookDAO(this);
        Intent in = getIntent();
        Bundle k = in.getExtras();

        maSachk = k.getString("MASACH");
        tensua = k.getString("TENSACH");
        tacsua = k.getString("TACGIA");
        nxbsua = k.getString("NXB");
        giasua = k.getString("GIABIA");
        sosua = k.getString("SOLUONG");

        maSach.setText(maSachk);
        tenSach.setText(tensua);
        tacgia.setText(tacsua);
        nxb.setText(nxbsua);
        giaban.setText(giasua);
        soluong.setText(sosua);
    }

    public void capsua(View view) {
        try {
            if (sachDAO.updateSach(maSachk, maSach.getText().toString(), tenSach.getText().toString(), tacgia.getText().toString(), nxb.getText().toString(), Double.parseDouble(giaban.getText().toString()), Integer.parseInt(soluong.getText().toString())) > 0) {
                Toast.makeText(getApplicationContext(), "Lưu thành công", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Lưu thất bại",
                        Toast.LENGTH_SHORT).show();
            }

        } catch (Exception ex) {
            String s = giaban.getText().toString();
            String t = soluong.getText().toString();
            if (maSach.getText().length() == 0 || tenSach.getText().length() == 0
                    || tacgia.getText().length() == 0 || nxb.getText().length() == 0
                    || giaban.getText().length() == 0 || soluong.getText().length() == 0) {
                Toast.makeText(getApplicationContext(), "Bạn chưa nhập đầy đủ thông tin ", Toast.LENGTH_SHORT).show();
            }
            try {
                Double.parseDouble(s);
                Integer.parseInt(t);
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Kiểm tra định dạng giá bán và số lượng ", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void quaysua(View view) {
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
