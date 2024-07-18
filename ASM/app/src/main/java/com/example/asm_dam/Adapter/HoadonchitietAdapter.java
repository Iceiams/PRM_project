package com.example.asm_dam.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asm1_ps09755.R;
import com.example.asm_dam.SQL_ASM.BillInfoDAO;
import com.example.asm_dam.model.HDCTmodel;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class HoadonchitietAdapter extends BaseAdapter {
    private Activity context;
    private LayoutInflater inflater;
    private List<HDCTmodel> arrHoaDonChiTiet;
    private BillInfoDAO hoaDonChiTietDAO;

    public HoadonchitietAdapter(Activity context, List<HDCTmodel> arrayHoaDonChiTiet) {
        super();
        this.context = context;
        this.arrHoaDonChiTiet = arrayHoaDonChiTiet;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        hoaDonChiTietDAO = new BillInfoDAO(context);
    }

    @Override
    public int getCount() {
        return arrHoaDonChiTiet.size();
    }

    @Override
    public Object getItem(int position) {
        return arrHoaDonChiTiet.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.hoadonchitietitem, parent, false);
            holder.txtMaSach = convertView.findViewById(R.id.tvMaSach);
            holder.txtSoLuong = convertView.findViewById(R.id.tvSoLuong);
            holder.txtGiaBia = convertView.findViewById(R.id.tvGiaBia);
            holder.txtThanhTien = convertView.findViewById(R.id.tvThanhTien);
            holder.imgDelete = convertView.findViewById(R.id.ivDelete);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        HDCTmodel item = arrHoaDonChiTiet.get(position);

        // Set data to views
        holder.txtMaSach.setText("Mã sách: " + item.getSach().getMaSach());
        holder.txtSoLuong.setText("Số lượng: " + item.getSoLuongMua());

        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        format.setMaximumFractionDigits(0);

        holder.txtGiaBia.setText("Giá bìa: " + format.format(item.getSach().getGiaBia()));

        double thanhTien = item.getSoLuongMua() * item.getSach().getGiaBia();
        holder.txtThanhTien.setText("Thành tiền: " + format.format(thanhTien));

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hoaDonChiTietDAO.deleteHoaDonChiTietByID(String.valueOf(arrHoaDonChiTiet.get(position).getMaHDCT()));
                arrHoaDonChiTiet.remove(position);
                notifyDataSetChanged();
            }
        });

        return convertView;
    }

    public void changeDataset(List<HDCTmodel> items) {
        this.arrHoaDonChiTiet = items;
        notifyDataSetChanged();
    }

    static class ViewHolder {
        TextView txtMaSach;
        TextView txtSoLuong;
        TextView txtGiaBia;
        TextView txtThanhTien;
        ImageView imgDelete;
    }
}