package com.example.asm_dam.Activity;

import android.content.Intent;
import android.os.Bundle;

import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.asm1_ps09755.R;
import com.example.asm_dam.Adapter.TheloaiAdapter;
import com.example.asm_dam.SQL_ASM.CategoryDAO;
import com.example.asm_dam.model.CategoryModel;

import java.util.ArrayList;
import java.util.List;


public class ListTheLoaiActivity extends AppCompatActivity {
    public static List<CategoryModel> dsTheLoai = new ArrayList<>();
    public static ListView lvTheLoai;
    TheloaiAdapter adapter = null;
    CategoryDAO theLoaiDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("CATEGORIES");
        setContentView(R.layout.fragment_the_loai_);
        lvTheLoai = findViewById(R.id.lvTheLoai);
        registerForContextMenu(lvTheLoai);

        theLoaiDAO = new CategoryDAO(ListTheLoaiActivity.this);
        dsTheLoai = theLoaiDAO.getAllTheLoai();
        adapter = new TheloaiAdapter(this, dsTheLoai);
        lvTheLoai.setAdapter(adapter);

        lvTheLoai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(ListTheLoaiActivity.this, TheLoaiDetailActivity.class);
                Bundle c = new Bundle();

                c.putString("MATHELOAI", dsTheLoai.get(position).getMaTheloai());
                c.putString("TENTHELOAI", dsTheLoai.get(position).getTenTheloai());
                c.putString("MOTA", dsTheLoai.get(position).getMoTa());
                c.putString("VITRI", String.valueOf(dsTheLoai.get(position).getViTri()));

                intent.putExtra("theloai",c);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menutheloai, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.addd:
                Intent intent = new Intent(ListTheLoaiActivity.this, TheLoaiActivity.class);
                startActivity(intent);
                return (true);
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        dsTheLoai.clear();
        dsTheLoai = theLoaiDAO.getAllTheLoai();
        adapter.changeDataset(dsTheLoai);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menucontext, menu);
        menu.setHeaderTitle("Chọn thông tin");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.eedit:
                Intent intent1 = new
                        Intent(ListTheLoaiActivity.this,TheLoaiDetailActivity.class);
                startActivity(intent1);
                return(true);
            case R.id.ddelete:
                Intent intent2 = new
                        Intent(ListTheLoaiActivity.this,Home.class);
                Toast.makeText(getApplicationContext(),"Error: Lỗi Không Xác Định , Vui Lòng Chậm Lại",
                        Toast.LENGTH_SHORT).show();
                startActivity(intent2);
                return(true);
        }
        return super.onContextItemSelected(item);
    }
}
