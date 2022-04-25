/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTQLCafe;

import java.math.BigDecimal;

/**
 *
 * @author USER
 */
public class SanPham {
    private String tinhTrang;
    private String thoiDiemBan;
    private String tenDoAn;
    private String tenDoUong;
    private BigDecimal gia;

    public SanPham(){
        
    }
     
    public SanPham(String tinhTrang, String thoiDiemBan, String tenDoAn, String tenDoUong, BigDecimal gia){
        this.tenDoAn = tenDoAn;
        this.tenDoUong = tenDoUong;
        this.gia = gia;
        this.tinhTrang = tinhTrang;
        this.thoiDiemBan = thoiDiemBan;
        
    }

    @Override
    public String toString() {
        return String.format("tenDoAn: %s\ntenDoUong: %s\ngia: %d",
          this.tenDoAn,this.tenDoUong, this.getGia());
    }   
    
    
    
    /**
     * @return the tenDoAn
     */
    public String getTenDoAn() {
        return tenDoAn;
    }

    /**
     * @param tenDoAn the tenDoAn to set
     */
    public void setTenDoAn(String tenDoAn) {
        this.tenDoAn = tenDoAn;
    }

    /**
     * @return the tenDoUong
     */
    public String getTenDoUong() {
        return tenDoUong;
    }

    /**
     * @param tenDoUong the tenDoUong to set
     */
    public void setTenDoUong(String tenDoUong) {
        this.tenDoUong = tenDoUong;
    }

    /**
     * @return the gia
     */
    public BigDecimal getGia() {
        return gia;
    }

    /**
     * @param gia the gia to set
     */
    public void setGia(BigDecimal gia) {
        this.gia = gia;
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

    /**
     * @return the thoiDiemBan
     */
    public String getThoiDiemBan() {
        return thoiDiemBan;
    }

    /**
     * @param thoiDiemBan the thoiDiemBan to set
     */
    public void setThoiDiemBan(String thoiDiemBan) {
        this.thoiDiemBan = thoiDiemBan;
    }

    
}
    
    
