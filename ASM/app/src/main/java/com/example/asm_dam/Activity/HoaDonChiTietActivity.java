package com.example.asm_dam.Activity;

import android.content.Intent;
import android.os.Bundle;

import android.view.MenuItem;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.asm1_ps09755.R;
import com.example.asm_dam.Adapter.HoadonchitietAdapter;
import com.example.asm_dam.SQL_ASM.BillInfoDAO;
import com.example.asm_dam.model.HDCTmodel;

import java.util.ArrayList;
import java.util.List;



public class HoaDonChiTietActivity extends AppCompatActivity {
    public List<HDCTmodel> dsHDCT = new ArrayList<>();
    ListView lvCart;
    HoadonchitietAdapter adapter = null;
    BillInfoDAO hoaDonChiTietDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("ORDER DETAILS");
        setContentView(R.layout.activity_hoadonchitiet);
        lvCart = findViewById(R.id.lvHoaDonChiTiet);
        hoaDonChiTietDAO = new BillInfoDAO(HoaDonChiTietActivity.this);
        Intent in = getIntent();
        Bundle b = in.getExtras();
        if (b != null) {
            dsHDCT = hoaDonChiTietDAO.getAllHoaDonChiTietByID(b.getString("MAHOADON"));
        }
        adapter = new HoadonchitietAdapter(this, dsHDCT);
        lvCart.setAdapter(adapter);
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