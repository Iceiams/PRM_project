package com.example.asm_dam.Activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.asm1_ps09755.R;
import com.example.asm_dam.SQL_ASM.BillInfoDAO;


import java.text.DecimalFormat;

public class ListThongKeActivity extends AppCompatActivity {
    TextView tvNgay, tvThang, tvNam;
    BillInfoDAO hoaDonChiTietDAO;
    DecimalFormat decimalFormat = new DecimalFormat("###,###,###");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("STATISTIC");
        setContentView(R.layout.activity_listthongke);
        tvNgay = findViewById(R.id.tvThongKeNgay);
        tvThang = findViewById(R.id.tvThongKeThang);
        tvNam = findViewById(R.id.tvThongKeNam);
        hoaDonChiTietDAO = new BillInfoDAO(this);

        double doanhThuNgay = hoaDonChiTietDAO.getDoanhThuTheoNgay();
        double doanhThuThang = hoaDonChiTietDAO.getDoanhThuTheoThang();
        double doanhThuNam = hoaDonChiTietDAO.getDoanhThuTheoNam();

        tvNgay.setText("Today      : " + decimalFormat.format(doanhThuNgay) + " VND");
        tvThang.setText("This month   : " + decimalFormat.format(doanhThuThang) + " VND");
        tvNam.setText("This year       : " + decimalFormat.format(doanhThuNam) + " VND");
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