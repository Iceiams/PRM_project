package com.example.asm_dam.Activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.asm1_ps09755.R;
import com.example.asm_dam.Adapter.TheloaiAdapter;
import com.example.asm_dam.SQL_ASM.CategoryDAO;
import com.example.asm_dam.model.CategoryModel;

import java.util.ArrayList;
import java.util.List;

import static com.example.asm_dam.Activity.ListTheLoaiActivity.lvTheLoai;

public class TheLoaiDetailActivity extends AppCompatActivity {
    EditText edMatheloai, edTentheloai, edMota, edVitri;
    CategoryDAO theloaiDAO;
    Button btnUpdate ;
    String  ten, vi, mo, user;
    public static List<CategoryModel> dsTheLoai = new ArrayList<>();
    TheloaiAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("CATEGORY DETAILS");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_theloaidetail);
        edMatheloai = findViewById(R.id.edMatheloai);
        edTentheloai = findViewById(R.id.edTentheloai);
        edMota = findViewById(R.id.edMota);

        edVitri = findViewById(R.id.edVitri);
        theloaiDAO = new CategoryDAO(this);
        btnUpdate = findViewById(R.id.btnUpda);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maloaisach = edMatheloai.getText().toString();
                String tenloaisach = edTentheloai.getText().toString();
                String mota = edMota.getText().toString();
                String vitri = edVitri.getText().toString();

                CategoryModel theloai = new CategoryModel(maloaisach,tenloaisach,mota,vitri);
                theloaiDAO.inserTheLoai(theloai);
                Toast.makeText(TheLoaiDetailActivity.this,"Thêm thành Công",Toast.LENGTH_LONG).show();


                //Cập Nhật lại ListView
                //theLoaiDAO = new CategoryDAO(ListTheLoaiActivity.this);
                dsTheLoai = theloaiDAO.getAllTheLoai();
                adapter = new TheloaiAdapter(TheLoaiDetailActivity.this, dsTheLoai);
                lvTheLoai.setAdapter(adapter);



            }
        });

    }

    public void updateU(View view) {

        if (theloaiDAO.updateInfoTheLoai(user, edMatheloai.getText().toString(), edTentheloai.getText().toString(), edMota.getText().toString(), edVitri.getText().toString()) > 0) {
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
