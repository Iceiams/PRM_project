package com.example.asm_dam.Activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.asm1_ps09755.R;
import com.example.asm_dam.Adapter.SachAdapter;
import com.example.asm_dam.SQL_ASM.BookDAO;
import com.example.asm_dam.model.Bookmodel;

import java.util.ArrayList;
import java.util.List;


public class ListBanChayActivity extends AppCompatActivity {
    public static List<Bookmodel> dsSach = new ArrayList<>();
    ListView lvBook;
    SachAdapter adapter = null;
    BookDAO sachDAO;
    EditText edThang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("BEST SELLER");
        setContentView(R.layout.activity_listbanchay);
        lvBook = findViewById(R.id.lvBookTop);
        edThang = findViewById(R.id.edThang);
    }

    public void VIEW_SACH_TOP_10(View view) {
        try {
            if (Integer.parseInt(edThang.getText().toString()) > 13 ||
                    Integer.parseInt(edThang.getText().toString()) < 0) {
                Toast.makeText(getApplicationContext(), "Không đúng định dạng tháng (1- 12)", Toast.LENGTH_SHORT).show();
            } else {
                sachDAO = new BookDAO(ListBanChayActivity.this);
                dsSach = sachDAO.getSachTop10(edThang.getText().toString());
                adapter = new SachAdapter(this, dsSach);
                lvBook.setAdapter(adapter);
            }
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Lỗi nhập không đúng kí tự", Toast.LENGTH_SHORT).show();
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