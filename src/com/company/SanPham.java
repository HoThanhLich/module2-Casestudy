package com.company;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class SanPham implements Serializable {
    private String maSP;
    private String tenSP;
    private int soLuongSP;
    private double giaSP;
    private Date hanSD;

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, int soLuongSP, double giaSP, Date hanSD) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuongSP = soLuongSP;
        this.giaSP = giaSP;
        this.hanSD = hanSD;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuongSP() {
        return soLuongSP;
    }

    public void setSoLuongSP(int soLuongSP) {
        this.soLuongSP = soLuongSP;
    }

    public double getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(double giaSP) {
        this.giaSP = giaSP;
    }

    public Date getHanSD() {
        return hanSD;
    }

    public void setHanSD(Date hanSD) {
        this.hanSD = hanSD;
    }

    @Override
    public String toString() {
        long ngayHetHan = 365*(this.hanSD.getNam()-1970) + (this.hanSD.getThang()*30+this.hanSD.getNgay());
        long ngayHienTai = (System.currentTimeMillis()/(3600*1000*24));
        long soNgayHSD = ngayHetHan - ngayHienTai;

        return "Mã: "+ this.maSP + ",\tTên: "+ this.tenSP + ",\tGiá: " + this.giaSP+ ",\tSL: " + this.soLuongSP + ",\tHSD: "
                + this.hanSD.toString() + ",\t Còn lại " + soNgayHSD + " (ngày)";
    }


}
