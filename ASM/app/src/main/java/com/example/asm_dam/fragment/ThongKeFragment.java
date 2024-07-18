package com.example.asm_dam.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.asm1_ps09755.R;
import com.example.asm_dam.Activity.Chitiet;
import com.example.asm_dam.Activity.ListBanChayActivity;
import com.example.asm_dam.Activity.ListHoaDonActivity;
import com.example.asm_dam.Activity.ListNguoiDungActivity;
import com.example.asm_dam.Activity.NguoiDungDetailActivity;
import com.example.asm_dam.Activity.ThemNguoiDungActivity;


public class ThongKeFragment extends Fragment {

    public CardView them_user, hoadon2, sachbanchay2, thongke2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thong_ke, container,false);
        them_user = view.findViewById(R.id.them_user);
        hoadon2 = view.findViewById(R.id.hoadon2);
        sachbanchay2 = view.findViewById(R.id.sachbanchay2);
        thongke2 = view.findViewById(R.id.thongke2);

        them_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ListNguoiDungActivity.class);
                startActivity(i);
            }
        });

        hoadon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ListHoaDonActivity.class);
                startActivity(i);
            }
        });
        sachbanchay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ListBanChayActivity.class);
                startActivity(i);
            }
        });
        thongke2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Chitiet.class);
                startActivity(i);
            }
        });

        return view;
    }
}
