package com.company;

import java.io.*;
import java.time.Duration;
import java.util.*;

public class QuanLyDanhSachSanPham {
    private static List<SanPham> danhSachSP = new ArrayList<>();

    public QuanLyDanhSachSanPham() {
        File file = new File("danhsach.txt");
        if (file.exists()) {
            readFile("danhsach.txt");
        }
    }

    public static void writeToFile(String path) {
        try {
            OutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(danhSachSP);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile(String s) {
        try {
            InputStream is = new FileInputStream("danhsach.txt");
            ObjectInputStream ois = new ObjectInputStream(is);
            danhSachSP = (List<SanPham>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public int size() {
        return danhSachSP.size();
    }

    public void hienThiDanhSachSP() {
        for (SanPham sanPham : danhSachSP) {
            System.out.println(sanPham);
        }
    }

    public List<SanPham> getDanhSachSP() {
        return danhSachSP;
    }

    public void setDanhSachSP(List<SanPham> danhSachSP) {
        this.danhSachSP = danhSachSP;
    }

    public void themSanPham(SanPham sanPham) {
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
            danhSachSP.set(index, sanPham);
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

//


}
