package com.company;

public class SanPham {
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
        return "Mã: "+ this.maSP + ",\tTên: "+ this.tenSP + ",\tGiá: " + this.giaSP+ ",\tSL: " + this.soLuongSP + ",\tHSD: "
                + this.hanSD.toString() ;
    }
}
