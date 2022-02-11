package com.company;

public class Date {
    private int ngay, thang, nam;

    public Date() {
        this.ngay = 0;
        this.thang = 0;
        this.nam = 0;
    }

    public Date(int ngay, int thang, int nam) {
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
    }

    public int getNgay() {
        return ngay;
    }

    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }
    @Override
    public String toString() {
        return ngay + "/" + thang + "/" + nam;
    }
}
