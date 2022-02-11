package com.company;

import java.util.ArrayList;
import java.util.List;

public class QuanLyDanhSachSanPham {
    private List<SanPham> danhSachSP = new ArrayList<>();

    public QuanLyDanhSachSanPham() {
    }

    public int size() {
        return danhSachSP.size();
    }

    public void hienThiDanhSachSP() {
        for (SanPham sanPham: danhSachSP) {
            System.out.println(sanPham);
        }
    }

    public List<SanPham> getDanhSachSP() {
        return danhSachSP;
    }

    public void setDanhSachSP(List<SanPham> danhSachSP) {
        this.danhSachSP = danhSachSP;
    }

    public void themSanPham (SanPham sanPham) {
        danhSachSP.add(sanPham);
    }

    public void timKiemTheoTenSP(String tenSP) {
        int index = -1;
        for (int i = 0; i < danhSachSP.size(); i++) {
            if (danhSachSP.get(i).getTenSP().equalsIgnoreCase(tenSP)) {
                System.out.println(danhSachSP.get(i));
                index = i;
            }
        }
        if (index == -1) {
            System.err.println("Không có SP tên:  " + tenSP);
        }
    }

    public int timKiemTheoMaSP(String maSP) {
        int index = -1;
        for (int i = 0; i < danhSachSP.size(); i++) {
            if (danhSachSP.get(i).getMaSP().equalsIgnoreCase(maSP)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean capNhatTheoMaSP(String maSP, SanPham sanPham) {
        int index = timKiemTheoMaSP(maSP);
        if (index != -1) {
            danhSachSP.set(index,sanPham);
            return true;
        } else {
            return false;
        }
    }

    public boolean xoatheoMaSP(String maSP) {
        int index = timKiemTheoMaSP(maSP);
        if (index != -1) {
            danhSachSP.remove(index);
            return true;
        } else {
            return false;
        }
    }


}
