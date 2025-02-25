package com.example.asm_dam.model;

import java.text.NumberFormat;
import java.util.Currency;

public class Bookmodel {
    private String maSach;
   public String maTheLoai;
    private String tenSach;
    private String tacGia;
    private String NXB;
    private double giaBia;
    private int soLuong;
    public Bookmodel() {
    }
    public Bookmodel(String maSach, String maTheLoai, String tenSach, String tacGia,
                String NXB, double giaBia, int soLuong) {
        this.maSach = maSach;
        this.maTheLoai = maTheLoai;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.NXB = NXB;
        this.giaBia = giaBia;
        this.soLuong = soLuong;
    }
    public String getMaSach() {
        return maSach;
    }
    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }
    public String getMaTheLoai() {
        return maTheLoai;
    }
    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }
    public String getTenSach() {
        return tenSach;
    }
    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }
    public String getTacGia() {
        return tacGia;
    }
    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }
    public String getNXB() {
        return NXB;
    }
    public void setNXB(String NXB) {
        this.NXB = NXB;
    }
    public double getGiaBia() {
        return giaBia;
    }
    public void setGiaBia(double giaBia) {
        this.giaBia = giaBia;
    }
    public int getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    @Override
    public String toString() {
        return "Sach{" + "maSach='" + maSach + '\'' + ", maTheLoai='" + maTheLoai + '\'' + ", tenSach='" + tenSach + '\'' + ", tacGia='" + tacGia + '\'' + ", NXB='" + NXB + '\'' + ", giaBia=" + giaBia + ", soLuong=" + soLuong + '}';
    }
    public String getFormattedGiaBia() {
        // Format giaBia into Vietnamese Dong
        NumberFormat format = NumberFormat.getCurrencyInstance();
        format.setMaximumFractionDigits(0); // Remove decimal places
        format.setCurrency(Currency.getInstance("VND")); // Set currency to VND
        return format.format(giaBia);
    }
}


