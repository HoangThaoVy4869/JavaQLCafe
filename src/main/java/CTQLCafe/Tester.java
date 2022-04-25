/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTQLCafe;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Tester {
    public static void main(String[] args) throws  InstantiationException, SQLException{
        Scanner scanner = new Scanner (System.in);
        QuanLyNhanVien ql = new QuanLyNhanVien();
        QuanLyBan qlb = new QuanLyBan();
        QuanLySanPham qlsp = new QuanLySanPham();
        NhanVien nv = new NhanVien();
        Ban b = new Ban();
        SanPham sp = new SanPham();
        GoiMon gm = new GoiMon();
        ThanhToan tt = new ThanhToan();
        Thongke tk = new Thongke();
        ThucDon td = new ThucDon();
        while (true) {
            System.out.println("----------------------- Quan ly quan cafe ------------------------");
            System.out.println("|| Enter 1: De quan ly nhan vien:                               ||");
            System.out.println("|| Enter 2: De quan ly thong tin ban:                           ||");
            System.out.println("|| Enter 3: De quan ly thuc an hoac thuc uong:                  ||");
            System.out.println("|| Enter 4: De xem danh sach nhan vien sinh nhat trong thang :  ||");
            System.out.println("|| Enter 5: De quan ly dat ban:                                 ||");
            System.out.println("|| Enter 6: De xuat hoa don:                                    ||");
            System.out.println("|| Enter 7: De xuat doanh thu theo thang:                       ||");
            System.out.println("|| Enter 8: De thoat chuong trinh:                              ||");
            System.out.println("------------------------------------------------------------------");
            System.out.println("MOI CHON: ");
            String line = scanner.nextLine();
            switch (line) {
                case "1": {
                    System.out.println("=============================================");
                    System.out.println("|  Nhap a: de xem ds nhan vien              |");
                    System.out.println("|  Nhap b: de tra cuu nhan vien             |");
                    System.out.println("|  Nhap c: de them thong tin nhan vien      |");
                    System.out.println("|  Nhap d: de cap nhat thong tin nhan vien  |");
                    System.out.println("|  Nhap e: de xoa thong tin nhan vien       |");
                    System.out.println("=============================================");
                    System.out.println("MOI CHON: ");
                    String type = scanner.nextLine();
                    switch (type) {
                        case "a": {
                            System.out.println("XEM DS NHAN VIEN");
                            ql.findAll();
                            break;
                        }
                        case "b": {
                            System.out.println("TRA CUU NHAN VIEN ");
                            ql.search(nv);
                            break;
                        }
                        case "c": {
                            System.out.println("THEM THONG TIN NHAN VIEN");
                            ql.insert(nv);
                            break;
                        }
                        case "d":{
                            System.out.println("CAP NHAT THONG TIN NHAN VIEN");
                            ql.update(nv);
                            break;
                        }
                        case "e":{
                            System.out.println("XOA THONG TIN NHAN VIEN ");
                            ql.delete(nv);
                            break;     
                        }
                        default:
                            System.out.println("Da thoat");
                            break;
                    }
                    break;
                }
                case "2": {
                    System.out.println("===========================================");
                    System.out.println("| Nhap a: de xem danh sach ban trong      |");
                    System.out.println("| Nhap b: de them thong tin ban           |");
                    System.out.println("| Nhap c: de cap nhat thong tin ban       |");
                    System.out.println("| Nhap d: de xoa thong tin ban            |");
                    System.out.println("| Nhap e: de tim kiem ban theo suc chua   |");
                    System.out.println("===========================================");
                    System.out.println("MOI CHON: ");
                    String type = scanner.nextLine();
                    switch (type) {
                        case "a": {
                            System.out.println("Danh sach ban trong la");
                            qlb.XemDSBT(b);
                            break;
                        }
                        case "b": {
                            System.out.println("Them thong tin ban");
                            qlb.insert(b);
                            break;
                        }
                        case "c": {
                            System.out.println("Cap nhat thong tin ban");
                            qlb.update(b);
                            break;
                        }
                        case "d": {
                            System.out.println("Xoa thong tin ban");
                            qlb.delete(b);
                            break;
                        }
                        case "e": {
                            System.out.println("Tim kiem theo suc chua");
                            qlb.search(b);
                            break;
                        }
                        default:
                            System.out.println("Da thoat");
                            break;
                    }
                    break;
                }
                case "3": {
                    System.out.println("==============================================================");
                    System.out.println("| Nhap a: de xem danh sach san pham                          |");
                    System.out.println("| Nhap b: de them thong tin san pham                         |");
                    System.out.println("| Nhap c: de cap nhat thong tin san pham                     |");
                    System.out.println("| Nhap d: de xoa thong tin san pham                          |");
                    System.out.println("| Nhap e: de tim kiem ban theo ten san pham hoac khoang gia  |");
                    System.out.println("| Nhap f: de sap xep thong tin san pham                      |");
                    System.out.println("==============================================================");
                    System.out.println("MOI CHON: ");
                    String type = scanner.nextLine();
                    switch (type) {
                        case "a": {
                            System.out.println("Danh sach san pham");
                            qlsp.findAll();
                            break;
                        }
                        case "b": {
                            System.out.println("Them thong tin san pham");
                            qlsp.insert(sp);
                            break;
                        }
                        case "c": {
                            System.out.println("Cap nhat thong tin san pham");
                            qlsp.update(sp);
                            break;
                        }
                        case "d": {
                            System.out.println("Xoa thong tin san pham");
                            qlsp.delete(sp);
                            break;
                        }
                        case "e": {
                            System.out.println("Tim kiem san pham");
                            qlsp.search(sp);
                            break;
                        }
                        case "f": {
                            System.out.println("Sap xep thong tin san pham");
                            qlsp.sort(sp);
                            break;
                        }
                        default:
                            System.out.println("Da thoat");
                            break;
                    }
                    break;
                }
                case "4": {
                   System.out.println("DANH SACH NHAN VIEN SINH TRONG THANG");
                   ql.check(nv);
                   break;
                }
                case "5": {
                    System.out.println("DAT BAN");
                    System.out.println("DANH SACH BAN TRONG LA");
                    qlb.XemDSBT(b);
                    System.out.println("Thuc Don");
                    td.findAll();
                    gm.DatBan();
                    System.out.println("DAT BAN THANH CONG");
                    gm.Luu();
                    break;
                }                
                case "6": {
                    System.out.println("HOA DON CUA QUY KHACH");
                    tt.Tong();
                    tt.TrangThai();
                    break;
                }
                case "7": {
                    System.out.println("THONG KE");
                    tk.statistical();
                    break;
                }
                case "8": {
                    System.out.println("CAM ON VI DA DUNG BUA TAI DAY!!HEN GAP LAI QUY KHACH");
                    return;
                }
                default:
                    System.out.println("Invalid");
                    continue;
            }
        }
    }
}
    

 
        
