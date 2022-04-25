/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTQLCafe;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class NhanVien {
    private String hoTen;
    private String gioiTinh;
    private String queQuan;
    private Date ngaySinh;
    private Date ngayvl;
    //private static int dem=0;
    //private int maNhanVien = ++dem;
    private int maNhanVien;

    public NhanVien(){
        
    }
    
    public NhanVien(int maNhanVien ,String hoTen, String gT, String queQuan, Date ngaySinh
    , Date ngayvl){
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngayvl = ngayvl;
        this.queQuan = queQuan;
        this.ngaySinh = ngaySinh;
    }
    
    public void nhapNv(Scanner scanner){
        System.out.println("Nhap ho ten:");
        this.hoTen = scanner.nextLine();
        System.out.println("Gioi Tinh: ");
        this.gioiTinh = scanner.nextLine();
        System.out.println("Que quan: ");
        this.maNhanVien= scanner.nextInt();
        System.out.println ("Nhap ngay nhan viec (ngay,thang,nam) phai hop le");
        String ngayvl = scanner.next();
        System.out.println ("Nhap ngay sinh cua nhan vien (ngay,thang,nam) phai hop le");
        String ngaySinh = scanner.next();
    }

    @Override
    public String toString() {
        return String.format("Ho ten: %s\nGioiTinh: %s\nQuequan: %s\nMaNV: %d",
                this.hoTen,this.gioiTinh,this.queQuan,this.maNhanVien);
    }
    
    
    /**
     * @return the hoTen
     */
    public String getHoTen() {
        return hoTen;
    }

    /**
     * @param hoTen the hoTen to set
     */
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    /**
     * @return the gioiTinh
     */
    public String getGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     * @return the queQuan
     */
    public String getQueQuan() {
        return queQuan;
    }

    /**
     * @param queQuan the queQuan to set
     */
    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    /**
     * @return the ngaySinh
     */
    public Date getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     * @return the ngayvl
     */
    public Date getNgayvl() {
        return ngayvl;
    }

    /**
     * @param ngayvl the ngayvl to set
     */
    public void setNgayvl(Date ngayvl) {
        this.ngayvl = ngayvl;
    }

    /**
     * @return the maNhanVien
     */
    public int getMaNhanVien() {
        return maNhanVien;
    }

    /**
     * @param maNhanVien the maNhanVien to set
     */
    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
    
    
}
