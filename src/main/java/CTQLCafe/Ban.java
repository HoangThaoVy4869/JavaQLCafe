/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTQLCafe;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Ban {
    private int soLuongBan;
    private int soGhe;
    private String maBan = "B00" + dem3;
    private static int dem3 = 1;
    private String tinhTrang;
    
    public Ban(){
        
    }    
   
    public Ban(int soLuongBan, int soGhe, String maBan, String tinhTrang){
        this.soGhe = soGhe;
        this.soLuongBan = soLuongBan;
        this.maBan = maBan;
        this.tinhTrang = tinhTrang;
    }
    public void NhapB (Scanner scanner){
        System.out.println("Nhap so luong ban");
        this.soLuongBan = scanner.nextInt();
        System.out.println("Nhap so luong ghe: ");
        this.soGhe = scanner.nextInt();
    }

    @Override
    public String toString() {
       return String.format("SoGhe: %d\nSoLuongBan: %d",
            this.soGhe,this.soLuongBan);
    }
    
    /**
     * @return the soLuongBan
     */
    public int getSoLuongBan() {
        return soLuongBan;
    }

    /**
     * @param soLuongBan the soLuongBan to set
     */
    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    /**
     * @return the soGhe
     */
    public int getSoGhe() {
        return soGhe;
    }

    /**
     * @param soGhe the soGhe to set
     */
    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }

    /**
     * @return the maBan
     */
    public String getMaBan() {
        return maBan;
    }

    /**
     * @param maBan the maBan to set
     */
    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    /**
     * @return the
     */
    public static int getDem3() {
        return dem3;
    }

    /**
     * @param aDem3 the to set
     */
    public static void setDem3(int aDem3) {
        dem3 = aDem3;
    }
    /**
     * @return the tinhTrang
     */
    public String getTinhTrang() {
        return tinhTrang;
    }

    /**
     * @param tinhTrang the tinhTrang to set
     */
    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

}

  
