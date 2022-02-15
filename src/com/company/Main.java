package com.company;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        QuanLyDanhSachSanPham quanLyDanhSachSanPham = new QuanLyDanhSachSanPham();

        int choice = -1, luaChon2;
        String input;
        do {
            menu();
            System.out.println("----Mời bạn chọn tính năng----");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    if (quanLyDanhSachSanPham.size() == 0) {
                        System.err.println("\tChưa có SP nào !!!");
                    } else {
                        System.out.println("\t\t\t-----------DANH SÁCH SẢN PHẨM-----------");
                        quanLyDanhSachSanPham.hienThiDanhSachSP();
                    }
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("1. Thêm SP");
                    System.out.println("2. Xóa SP");
                    System.out.println("0. Quay lại");
                    luaChon2 = scanner.nextInt();
                    switch (luaChon2) {
                        case 0:
                            break;
                        case 1:
                            do {
                                SanPham sanPham = nhapThongTinSP();
                                quanLyDanhSachSanPham.themSanPham(sanPham);
                                System.out.println("--------------NHẬP THÀNH CÔNG--------------");
                                System.out.println(sanPham);
                                System.out.println("-----------------------------------------");
                                System.out.println("1. Tiếp tục");
                                System.out.println("0. Quay lại");
                                luaChon2 = scanner.nextInt();
                            } while (luaChon2 != 0);
                            break;
                        case 2:
                            do {
                                if (quanLyDanhSachSanPham.size() == 0) {
                                    System.err.println("Hiện tại danh sách rỗng !!!");
                                    System.out.println("Chọn 0 để quay lại.");
                                    luaChon2 = scanner.nextInt();
                                } else {
                                    scanner.nextLine();
                                    System.out.print("Nhập mã SP: ");
                                    String maSP = scanner.nextLine();

                                    if (quanLyDanhSachSanPham.xoatheoMaSP(maSP)) {
                                        System.out.println("--------------XÓA THÀNH CÔNG!!!--------------");
                                        System.out.println(quanLyDanhSachSanPham.maMuonXoa);
                                    } else {
                                        System.err.println("--------------THẤT BẠI-MÃ KHÔNG TỒN TẠI--------------");
                                    }
                                    System.out.println("1. Tiếp tục");
                                    System.out.println("0. Quay lại");
                                    luaChon2 = scanner.nextInt();
                                }
                            } while (luaChon2 != 0);
                            break;
                    }
                    break;
                case 3:
                    if (quanLyDanhSachSanPham.size() == 0) {
                        System.err.println("\t Danh sách rỗng!!!");
                        System.out.println("\t Vui lòng chọn lại ==>");
                        break;
                    } else {
                        do {
                            scanner.nextLine();
                            System.out.println("Nhập mã SP cần cập nhật: ");
                            String maSP = scanner.nextLine();
                            if (quanLyDanhSachSanPham.timKiemTheoMaSP(maSP) == -1) {
                                System.err.println("Thất bại - không tim thấy !!!");
                                luaChon2 = 0;
                            } else {
                                System.out.println(quanLyDanhSachSanPham.getDanhSachSP().get(quanLyDanhSachSanPham.timKiemTheoMaSP(maSP)));
                                System.out.println("Cập nhật SP");
                                SanPham sanPhamMoi = nhapThongTinSP();
                                if (quanLyDanhSachSanPham.capNhatTheoMaSP(maSP, sanPhamMoi)) {
                                    System.out.println("Cập nhật thành công !!!");
                                } else {
                                    System.err.println("Thất bại !!!");
                                }
                                System.out.println("1. Tiếp tục");
                                System.out.println("0. Quay lại");
                                luaChon2 = scanner.nextInt();
                            }

                        } while (luaChon2 != 0);
                    }
                    break;
                case 4:
                    if (quanLyDanhSachSanPham.size() == 0) {
                        System.err.println("Danh sách rỗng !!!");
                    } else {
                        System.out.println("1. Theo tên SP");
                        System.out.println("2. Theo mã SP");
                        System.out.println("0. Quay lại");
                        luaChon2 = scanner.nextInt();
                        if (luaChon2 == 0) {
                            break;
                        } else {
                            switch (luaChon2) {
                                case 1:
                                    scanner.nextLine();
                                    System.out.print("Nhập tên SP: ");
                                    input = scanner.nextLine();
                                    if (input.trim().equals("")) {
                                        do {
                                            System.err.println("Bạn chua nhập tên SP");
                                            System.out.print("Nhập lại: ");
                                            input = scanner.nextLine();
                                        } while (input.trim().equals(""));

                                    } else {
                                        quanLyDanhSachSanPham.timKiemTheoTenSP(input);
                                    }


                                    break;
                                case 2:
                                    System.out.println("Nhập mã SP: ");
                                    scanner.nextLine();
                                    input = scanner.nextLine();
                                    int index = quanLyDanhSachSanPham.timKiemTheoMaSP(input);
                                    if (index == -1) {
                                        System.err.printf("Không có mã %s trong danh sách", input);
                                    } else {
                                        System.out.println(quanLyDanhSachSanPham.getDanhSachSP().get(index));
                                    }
                                    break;
                            }
                        }
                    }
                    break;
                case 5:
                    do {
                        menuSapXep();
                        luaChon2 = scanner.nextInt();
                        switch (luaChon2) {
                            case 1:
                                quanLyDanhSachSanPham.sapXepTheoGia();
                                quanLyDanhSachSanPham.hienThiDanhSachSP();
                                break;
                            case 2:
                                quanLyDanhSachSanPham.sapXepTheoSoLuong();
                                quanLyDanhSachSanPham.hienThiDanhSachSP();
                                break;
                            case 3:
                                quanLyDanhSachSanPham.sapXepTheoHanSuDung();
                                quanLyDanhSachSanPham.hienThiDanhSachSP();
                                break;
                        }
                    } while (luaChon2 != 0);
                    break;
            }
            quanLyDanhSachSanPham.writeToFile("danhsach.txt");
        } while (choice != 0);
    }

    private static void menuSapXep() {
        System.out.println("---Cách thực hiện---");
        System.out.println("1. Theo Giá");
        System.out.println("2. Theo số lượng");
        System.out.println("3. Theo HSD");
        System.out.println("0. Quay lại");
    }


    private static SanPham nhapThongTinSP() {
        scanner.nextLine();
        System.out.print("Nhập mã SP:  ");
        String maSP = scanner.nextLine();
        while (maSP.trim().equals("")) {
            System.out.println("Tên không hợp lệ !!!");
            System.out.println("Nhập lại: ");
            maSP = scanner.nextLine();
        }
        System.out.print("Nhập tên SP:  ");
        String tenSP = scanner.nextLine();
        while (tenSP.trim().equals("")) {
            System.out.println("Tên không hợp lệ !!!");
            System.out.println("Nhập lại: ");
            tenSP = scanner.nextLine();
        }
        System.out.print("Nhập SL:  ");
        int soLuongSP = scanner.nextInt();
        if (soLuongSP <= 0) {
            System.out.println("Số lượng không hợp lệ !!!");
        }
        System.out.print("Nhập giá:  ");
        int giaSP = scanner.nextInt();
        if (giaSP < 0) {
            System.out.println("Giá không hợp lệ !!!");
        }
        scanner.nextLine();
        System.out.println(" HSD:");
        System.out.print(" Ngày: ");
        int ngay = scanner.nextInt();
        while (ngay <= 0 || ngay > 31) {
            System.out.println("Ngày không hợp lệ !!!");
            System.out.print("Nhập lại:  ");
            ngay = scanner.nextInt();
        }
        System.out.print(" Tháng: ");
        int thang = scanner.nextInt();
        while (thang <= 0 || thang > 12) {
            System.out.println("tháng không hợp lệ !!!");
            System.out.print(" Nhập lại:  ");
            thang = scanner.nextInt();
        }
        System.out.print(" Năm: ");
        int nam = scanner.nextInt();
        while (nam <= 2021) {
            System.out.println("Năm không hợp lệ !!!");
            System.out.print("Nhập lại:  ");
            nam = scanner.nextInt();
            scanner.next();
        }
        Date hanSD = new Date(ngay, thang, nam);
        SanPham sanPham = new SanPham(maSP, tenSP, soLuongSP, giaSP, hanSD);
        return sanPham;
    }

    private static void menu() {
        System.out.println("\t-----ỨNG DỤNG QUẢN LÝ SẢN PHẨM-----");
        System.out.println("\t1. Hiển thị danh sách sản phẩm");
        System.out.println("\t2. Thêm và xóa sản phẩm");
        System.out.println("\t3. Cập nhật sản phẩm");
        System.out.println("\t4. Tìm kiếm sản phẩm");
        System.out.println("\t5. Thống kê sắp xếp");
        System.out.println("\t0. Thoát chương trình");
    }
}
