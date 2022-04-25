/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTQLCafe;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USER
 */


public class QuanLySanPham {
    
 
    ///// JDBC<MySQL>
    /// lay ds nhan vien
    public List<SanPham> findAll() throws SQLException {
        List<SanPham> ds = new ArrayList<>();
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3333/qlqcafe","root","01278587557");
           
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM sanpham");
                while (rs.next()){
                    int maSanPham = rs.getInt("maSanPham");
                    String tenSanPham = rs.getString("tenSanPham");
                    String tinhTrang = rs.getString("tinhTrang");
                    String thoiDiemBan = rs.getString("thoiDiemBan");
                    BigDecimal gia = rs.getBigDecimal("gia");
                    String thongtin = rs.getString("thongtin");
                    System.out.printf("%d - %s - %s - %s - %f -%s-\n",maSanPham,tenSanPham,tinhTrang,thoiDiemBan,gia,thongtin);  
                }
                stmt.close();
                conn.close();
        return ds;
    }
    public void insert(SanPham sp) throws SQLException {
     
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3333/qlqcafe","root","01278587557");
            
                  
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ten San Pham:");
            String tenSanPham = scanner.nextLine();
            System.out.println("Tinh Trang: ");
            String tinhTrang = scanner.nextLine();
            System.out.println("Thoi diem ban: ");
            String thoiDiemBan = scanner.nextLine();
            System.out.println("Nhap thong tin sp nhu co da hay co phai san pham chay: ");
            String thongTin = scanner.nextLine();
            System.out.println("Gia: ");
            BigDecimal gia = scanner.nextBigDecimal();

            String sql= "insert into sanpham(tenSanPham,tinhTrang,thoiDiemBan,gia,thongtin) values('"+tenSanPham+"','"+tinhTrang+"','"+thoiDiemBan+"','"+gia+"','"+thongTin+"')";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.executeUpdate();
            findAll();
            conn.close();
            
        }
        
       
    public void update(SanPham sp) throws SQLException {
        
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3333/qlqcafe","root","01278587557");
        
            //Statement stmt = conn.prepareCall(sql);
            
            Scanner scanner = new Scanner(System.in);
            System.out.println("Vui long nhap ma san pham de cap nhat: ");
            int maSanPham = scanner.nextInt();
            scanner.nextLine();
                       
            System.out.println("Ten San Pham: ");
            String tenSanPham = scanner.nextLine();
            System.out.println("Tinh Trang: ");
            String tinhTrang = scanner.nextLine();
            System.out.println("Thoi diem ban: ");
            String thoiDiemBan = scanner.nextLine();
            System.out.println("Nhap thong tin sp nhu co da hay co phai san pham chay: ");
            String thongTin = scanner.nextLine();
            System.out.println("Gia: ");
            BigDecimal gia = scanner.nextBigDecimal();

            
            String sql= "update sanpham set  tenSanPham='"+tenSanPham+"',tinhTrang='"+tinhTrang+"',thoiDiemBan='"+thoiDiemBan+"',gia='"+gia+"',thongTin='"+thongTin+"' where maSanPham ="+maSanPham;
            Statement stmt = conn.prepareCall(sql);
            
            stmt.executeUpdate(sql);
            findAll();
            conn.close();
        
    }
    
    public void delete(SanPham sp) throws SQLException {
        
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3333/qlqcafe","root","01278587557");
            
            Scanner scanner = new Scanner(System.in);
            System.out.println("Vui long nhap ma san pham de xoa: ");
            int maSanPham = scanner.nextInt();
            String sql= "delete from sanpham where maSanPham ="+ maSanPham;
            Statement stmt = conn.prepareCall(sql);
            stmt.executeUpdate(sql);
            findAll();
            conn.close();
   
    }
    
    public void sort(SanPham sp) throws SQLException {
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3333/qlqcafe","root","01278587557");
        
        System.out.println("Sap xep ds san pham giam dan theo gia ban: ");
        String sql = "SELECT * FROM sanpham ORDER BY gia DESC";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            System.out.printf("%d: %s - %s - %s - %fs - %s -\n",
                    rs.getInt("maSanPham"), rs.getString("tenSanPham"), rs.getString("tinhTrang"), rs.getString("thoiDiemBan"), rs.getBigDecimal("gia"), rs.getString("thongTin"));
        }
        conn.close();
    }
    
    public void search(SanPham sp) throws SQLException{
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3333/qlqcafe","root","01278587557");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui long nhap ten san pham hoac khoang gia de tim kiem: ");
        String key = scanner.nextLine();
        String sql = "SELECT * FROM sanpham WHERE(tenSanPham LIKE '"+key+"')OR(gia ='"+key+"')";
        PreparedStatement stmt = conn.prepareStatement(sql);///%key%
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            System.out.println("DANH SACH SAN PHAM DUOC TRA CUU LA");
            System.out.printf("%d: %s - %s - %s - %fs - %s -\n",
                    rs.getInt("maSanPham"),rs.getString("tenSanPham"),rs.getString("tinhTrang"),rs.getString("thoiDiemBan"),rs.getBigDecimal("gia"),rs.getString("thongTin"));
        }
        conn.close();
    }
}





/*
public class QuanLySanPham {
    private List<SanPham> dssp = new LinkedList<>();
    
    public QuanLySanPham(){
        this.dssp = new ArrayList<>();
    }
    public void themSanPham(SanPham sp){
        this.getDssp().add(sp);
    }
    
    @Override
    public String toString() {
        String k="";
        for(SanPham sp: this.getDssp())
            k += sp + "============\n";
        return k;
    }
    
    public boolean xoaThongTinTheoTenThucAn(String tenthucU){
        SanPham sp = this.getDssp().stream()
                .filter(dssp -> dssp.getTenDoAn()
                .equals(tenthucU)).findFirst().orElse(null);
                if (sp == null) {
            return false;
        }
                this.getDssp().remove(sp);
        return false;
    }
    public boolean xoaThongTinBanTheoTenThucUong(String tenThucAn){
        SanPham sp = this.getDssp().stream()
                .filter(dssp -> dssp.getTenDoAn()
                .equals(tenThucAn)).findFirst().orElse(null);
                if (sp == null) {
            return false;
        }
                this.getDssp().remove(sp);
        return false;
    }
    
    public List<SanPham> timkiemDoAn (String tenDoA){
        return this.getDssp().stream().filter(sp -> sp.getTenDoAn().contains(tenDoA) == true)
                .collect(Collectors.toList());
    }
    
    public List<SanPham> timkiemDoU (String tenDoU){
        return this.getDssp().stream().filter(sp -> sp.getTenDoUong().contains(tenDoU) == true)
                .collect(Collectors.toList());
    }
    
    public List<SanPham> timKiemtheoGia(BigDecimal fromPrice, BigDecimal toPrice) {
        return this.getDssp().stream()
                .filter(sp -> sp.getGia().compareTo(fromPrice) >= 0 
                        && sp.getGia().compareTo(toPrice) <= 0)
                .collect(Collectors.toList());
    }

    
        public void sxGiamTheoGia() {
        this.dssp.sort((sp1, sp2) -> -sp1.getGia().compareTo(sp2.getGia()));
    }


    public void xuat() {
        this.getDssp().forEach((sp) -> {
            System.out.println(sp);
        });
    }


    public List<SanPham> getDssp() {
        return dssp;
    }


    public void setDssp(List<SanPham> dssp) {
        this.dssp = dssp;
    }

}
*/
