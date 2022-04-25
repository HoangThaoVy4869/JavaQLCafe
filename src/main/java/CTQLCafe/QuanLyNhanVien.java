/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTQLCafe;

import java.sql.Connection;
import java.sql.Date;
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
public class QuanLyNhanVien {
    
 
    ///// JDBC<MySQL>
    /// lay ds nhan vien
    public List<NhanVien> findAll() throws SQLException {
        List<NhanVien> ds = new ArrayList<>();
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3333/qlqcafe","root","01278587557");
           
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM nhanvien");
                while (rs.next()){
                    int maNhanVien = rs.getInt("maNhanVien");
                    String hoTen = rs.getString("hoTen");
                    String gioiTinh = rs.getString("gioiTinh");
                    String queQuan = rs.getString("queQuan");
                    Date ngaySinh = rs.getDate("ngaySinh");
                    Date ngayvl = rs.getDate("ngayvl");
                    String maBoPhan = rs.getString("maBoPhan");
                    String tenBoPhan = rs.getString("tenBoPhan");
                    System.out.printf("%d - %s - %s - %s - %s - %s - %s - %s\n",maNhanVien,hoTen,gioiTinh,queQuan,ngaySinh,ngayvl,maBoPhan,tenBoPhan);  
                }
                stmt.close();
                conn.close();
        return ds;
    }
    public void insert(NhanVien nv) throws SQLException {
     
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3333/qlqcafe","root","01278587557");
            
                  
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhap Ho ten: ");
            String hoTen = scanner.nextLine();
            System.out.println("Nhap Gioi Tinh:");
            String gioiTinh = scanner.nextLine();
            System.out.println("Nhap Que Quan: ");
            String queQuan = scanner.nextLine();
            System.out.println("Nhap Ma Bo Phan:");
            String maBoPhan = scanner.nextLine();
            System.out.println("Nhap Ten Bo Phan:");
            String tenBoPhan = scanner.nextLine();
            System.out.println("Nhap Ngay Sinh(nhap lien tiep namthangngay): ");
            String ngaySinh = scanner.next();
            System.out.println("Nhap Ngay vao lam(nhap lien tiep namthangngay): ");
            String ngayvl = scanner.next();
            
            String sql= "insert into nhanvien(hoTen,gioiTinh,queQuan,ngaySinh,ngayvl,maBoPhan,tenBoPhan) values('"+hoTen+"','"+gioiTinh+"','"+queQuan+"','"+ngaySinh+"','"+ngayvl+"','"+maBoPhan+"','"+tenBoPhan+"')";
            PreparedStatement stmt = conn.prepareStatement(sql);
          
            /*stmt.setInt(1, nv.getMaNhanVien());
            stmt.setString(2, nv.getHoTen());
            stmt.setString(3, nv.getGioiTinh());
            stmt.setString(4, nv.getQueQuan());
            stmt.setDate(5, (Date) nv.getNgaySinh());
            stmt.setDate(6, (Date) nv.getNgayvl());*/
            
            stmt.executeUpdate();
            findAll();
            conn.close();
            
        }
        
       
    public void update(NhanVien nv) throws SQLException {
        
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3333/qlqcafe","root","01278587557");
        
            //Statement stmt = conn.prepareCall(sql);
            
            Scanner scanner = new Scanner(System.in);
            System.out.println("Vui long nhap ma nhan vien de cap nhat: ");
            int maNhanVien = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Nhap Ho ten: ");
            String hoTen = scanner.nextLine();
            System.out.println("Nhap Gioi Tinh:");
            String gioiTinh = scanner.nextLine();
            System.out.println("Nhap Que Quan: ");
            String queQuan = scanner.nextLine();
            System.out.println("Nhap Ma Bo Phan:");
            String maBoPhan = scanner.nextLine();
            System.out.println("Nhap Ten Bo Phan:");
            String tenBoPhan = scanner.nextLine();
            System.out.println("Nhap Ngay Sinh(nhap lien tiep namthangngay): ");
            String ngaySinh = scanner.next();
            System.out.println("Nhap Ngay vao lam(nhap lien tiep namthangngay): ");
            String ngayvl = scanner.next();
            
            String sql= "update nhanvien set hoTen= '"+ hoTen + "', gioiTinh='"+gioiTinh+"',queQuan='"+queQuan+"',ngaySinh='"+ngaySinh+"',ngayvl='"+ngayvl+"',tenBoPhan='"+tenBoPhan+"',maBoPhan='"+maBoPhan+"' where maNhanVien ="+maNhanVien;
            Statement stmt = conn.prepareCall(sql);
            
            stmt.executeUpdate(sql);
            findAll();
            conn.close();
        
    }
    
    public void delete(NhanVien nv) throws SQLException {
        
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3333/qlqcafe","root","01278587557");
            
            Scanner scanner = new Scanner(System.in);
            System.out.println("Vui long nhap ma nhan vien de xoa: ");
            int maNhanVien = scanner.nextInt();
            String sql= "delete from nhanvien where maNhanVien ="+ maNhanVien;
            Statement stmt = conn.prepareCall(sql);
            stmt.executeUpdate(sql);
            findAll();
            conn.close();
   
    }
    
    public void check(NhanVien nv) throws SQLException {
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3333/qlqcafe","root","01278587557");
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui long nhap thang sinh nhan vien de kiem tra: ");
        String thangSinh = scanner.next();
        String sql = "SELECT * FROM nhanvien WHERE MONTH(ngaySinh) ="+thangSinh;

        PreparedStatement stmt = conn.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            System.out.printf("%d: %s - %s\n",
                    rs.getInt("maNhanVien"),rs.getString("hoTen"),rs.getDate("ngaySinh"));
        }
    }
    
    public void search(NhanVien nv) throws SQLException{
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3333/qlqcafe","root","01278587557");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui long nhap ho ten/gioi tinh/ngay sinh/que quan de tim kiem: ");
        String key = scanner.nextLine();
        String sql = "SELECT * FROM nhanvien WHERE(hoTen LIKE '"+key+"')OR(gioiTinh LIKE '"+key+"')OR(ngaySinh LIKE '"+key+"')OR(queQuan LIKE '"+key+"')";
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            System.out.println("DANH SACH NHAN VIEN DUOC TRA CUU LA");
            System.out.printf("%d: %s - %s - %s - %s - %s - %s - %s \n",
                    rs.getInt("maNhanVien"),rs.getString("hoTen"),rs.getString("gioiTinh"),rs.getString("queQuan"),rs.getDate("ngaySinh"),rs.getDate("ngayvl"),rs.getString("maBoPhan"),rs.getString("tenBoPhan"));
        }
    }
    
    /*
    /// JAVA 
    private List<NhanVien> ds;
    
    public QuanLyNhanVien(){
        this.ds = new ArrayList<>();
    }
    public void themNv(NhanVien nv){
        this.getDs().add(nv);
    }

    @Override
    public String toString() {
        String s="";
        for(NhanVien nv: this.getDs())
            s += nv + "============\n";
        return s;
    }
    
    public boolean xoaThongTinBanTheoTenNV(String tenNV){
        NhanVien nv = this.getDs().stream()
                .filter(ds -> ds.getHoTen()
                .equals(tenNV)).findFirst().orElse(null);
                if (nv == null) {
            return false;
        }
                this.getDs().remove(nv);
        return false;
    }
    
    public void CapNhat(ArrayList<NhanVien> arr) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap Ho Ten Nhan Vien can cap nhat: ");
        String nhapHoTenNV = sc.nextLine();
        for (NhanVien nv : arr) {
            if (nv.getHoTen().equals(nhapHoTenNV)) {
                System.out.println("Cap nhat Ma Nhan Vien: ");
                nv.setMaNhanVien(sc.nextInt());
                System.out.println("Cap nhat Ho ten NV: ");
                nv.setHoTen(sc.nextLine());
                System.out.println("Cap nhat Gioi Tinh: ");
                nv.setGioiTinh(sc.nextLine());
                System.out.println("Cap nhat Que Quan: ");
                nv.setQueQuan(sc.nextLine());
                break;
            }
            else{
                System.out.println("Khong ton tai ban nay!");
            }
        }
    }
    
    
    public void themNv2(Scanner scanner, String tenLop) throws ClassNotFoundException, NoSuchElementException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
            Class c= Class.forName(tenLop);
            
            NhanVien n= (NhanVien) c.getDeclaredConstructor().newInstance();
            
            n.nhapNv(scanner);
            this.themNv(n);
    }
    public QuanLyNhanVien traCuu(String kw){
        QuanLyNhanVien q = new QuanLyNhanVien();
        kw=kw.toLowerCase();
        for(NhanVien nv: this.getDs())
            if(nv.getHoTen().toLowerCase().contains(kw)|| nv.getGioiTinh().toLowerCase().contains(kw)||
                    nv.getQueQuan().toLowerCase().contains(kw))
                q.themNv(nv);
        return q;
    }
    
    
    /*public List<NhanVien> searchStaffByName(String hoTen) {
        return this.ds.stream().filter(nv -> nv.getHoTen().contains(hoTen)).collect(Collectors.toList());
    }    
    public List<NhanVien> searchStaffBySex(String gioiTinh) {
        return this.ds.stream().filter(nv -> nv.getGioiTinh().contains(gioiTinh)).collect(Collectors.toList());
    }   
    public List<NhanVien> searchStaffByRegion(String queQuan) {
        return this.ds.stream().filter(nv -> nv.getQueQuan().contains(queQuan)).collect(Collectors.toList());
    } */  

    /**
     * @return the ds
     */
    /*
    public List<NhanVien> getDs() {
        return ds;
    }

    /**
     * @param ds the ds to set
     
    public void setDs(List<NhanVien> ds) {
        this.ds = ds;
    } */
 
}
