/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTQLCafe;

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
public class QuanLyBan {

    public List<Ban> findAll() throws SQLException {
        List<Ban> dsb = new ArrayList<>();
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3333/qlqcafe", "root", "01278587557");

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM ban");
        while (rs.next()) {
            String maBan = rs.getString("maBan");
            int soGhe = rs.getInt("soGhe");
            String tinhTrang = rs.getString("tinhTrang");
            System.out.printf("%s - %d - %s\n", maBan, soGhe, tinhTrang);
        }
        stmt.close();
        conn.close();
        return dsb;
    }

    public void insert(Ban b) throws SQLException {

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3333/qlqcafe", "root", "01278587557");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so luong ghe cho mot khu vuc: ");
        int soGhe = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhap Tinh Trang Ban: ");
        String tinhTrang = scanner.nextLine();
        String sql = "insert into ban(soGhe,tinhTrang) values('" + soGhe + "','" + tinhTrang + "')";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.executeUpdate();
        findAll();
        conn.close();

    }

    public void update(Ban b) throws SQLException {

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3333/qlqcafe", "root", "01278587557");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma Ban: ");
        String maBan = scanner.nextLine();
        System.out.println("Nhap so luong ghe cho mot khu vuc: ");
        int soGhe = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhap Tinh Trang Ban: ");
        String tinhTrang = scanner.nextLine();
        String sql = "update ban set soGhe='" + soGhe + "',tinhTrang='" + tinhTrang + "' where maBan =" +maBan;
        Statement stmt = conn.prepareCall(sql);

        stmt.executeUpdate(sql);
        findAll();
        conn.close();

    }

    public void delete(Ban b) throws SQLException {

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3333/qlqcafe", "root", "01278587557");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui long nhap ma ban de xoa: ");
        String maBan = scanner.nextLine();
        String sql = "delete from ban where maBan =" + maBan;
        Statement stmt = conn.prepareCall(sql);
        stmt.executeUpdate(sql);
        findAll();
        conn.close();

    }

    public void search(Ban b) throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3333/qlqcafe", "root", "01278587557");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui long nhap so cho ngoi de tim kiem: ");
        String soGhe = scanner.nextLine();
        String sql = "SELECT * FROM ban WHERE soGhe =" + soGhe;
        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            System.out.println("DANH SACH BAN DUOC TRA CUU LA");
            System.out.printf("%s: %d - %s \n",
                    rs.getString("maBan"), rs.getInt("soGhe"), rs.getString("tinhTrang"));
        }
    }

    public void XemDSBT(Ban b) throws SQLException {

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3333/qlqcafe", "root", "01278587557");
        Scanner scanner = new Scanner(System.in);
        String sql = "SELECT * FROM ban WHERE tinhTrang ='Trong'";
        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            System.out.printf("%s: %d - %s\n",
                    rs.getString("maBan"), rs.getInt("soGhe"), rs.getString("tinhTrang"));

        }
    }

}

/*

public class QuanLyBan {
    private List<Ban> dsb;
    ResultSet rs;
    java.sql.Statement stm;
    private Ban b;
    
    
    public Vector<Vector<String>> getAll() throws ClassNotFoundException, SQLException {
	Vector<Vector<String>> data = new Vector<>();

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3333/quanlycafe","root","01278587557");
	// Kết nối database
	//connection = getConnect();

	// Tạo câu lệnh SQL (Cách 1: dùng Statement)
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("Select * from ban");
	while (rs.next()) {

	    // Lấy dữ liệu từ ResultSet
	    String maBan = rs.getString(1);
	   //Integer soGhe = rs.getInt(2);
	   // int SoBan = rs.getInt(3);

	    // Ghi vào vector
	    Vector<String> temp = new Vector<>();
	    temp.add(maBan);

	    // Thêm dữ liệu vào data vector chính
	    data.add(temp);
	}
	return data;
    }
    
    
    
    public QuanLyBan(){
        this.dsb = new ArrayList<>();
    }
    public void themBan(Ban b){
        this.getDsb().add(b);
    }

    @Override
    public String toString() {
        String s1="";
        for(Ban b: this.getDsb())
            s1 += b + "============\n";
        return s1;
    }
    
    public boolean xoaThongTinBanTheoMaBan(String maBan){
        Ban b = this.getDsb().stream()
                .filter(dsb -> dsb.getMaBan()
                .equals(maBan)).findFirst().orElse(null);
                if (b == null) {
            return false;
        }
                this.getDsb().remove(b);
        return false;
    }
    
    public void CapNhat(ArrayList<Ban> arr) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap Ma Ban can cap nhat: ");
        String nhapMB = sc.nextLine();
        for (Ban b : arr) {
            if (b.getMaBan().equals(nhapMB)) {
                System.out.println("Cap nhat Ma Ban: ");
                b.setMaBan(sc.nextLine());
                System.out.println("Cap nhat So Ghe: ");
                b.setSoGhe(sc.nextInt());
                System.out.println("Cap nhat So Ban: ");
                b.setSoLuongBan(sc.nextInt());
                break;
            }
            else{
                System.out.println("Khong ton tai ban nay!");
            }
        }
    }
    
    public Ban timKiem(int soGhe){
        for(Ban b : this.getDsb())
            if(b.getSoGhe() == soGhe)
                return b;
        return null;
    }

    public void xuat() {
        this.getDsb().forEach((b) -> {
       System.out.println(b);
    });
    }
    
    public void XemDSBT(){
        try
        {
            connect();
            ResultSet rs = stm.executeQuery("SELECT BanID FROM Goi_mon");
            for(int i = 0; i< b.getSoLuongBan();i++)//n là số bàn
            {
                String s = b.getMaBan(i);
                rs.first();
                boolean flag = false;
                while(!rs.isAfterLast())
            {
                if(rs.getString(1).equals(s))
                {
                    flag = true;
                    break;
                }
                rs.next();
            }
                if(flag == true)
                    System.out.println("Ban" + b.getMaBan(i)+" da duoc su dung");
                else
                     System.out.println("Ban" + b.getMaBan(i)+" chua duoc su dung");
                }
            }
                catch(Exception e)
            {
                System.err.println("Error: "+e.toString());
            }
        } 
       
    public void connect (){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException ex)
        {
            System.out.print("Loi: " + ex.getMessage());
        }
        try{
               Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3333/demo2","root","01278587557");
               Statement stm = conn.createStatement();
        } catch(SQLException se) {
            System.err.println("Loi!!" + se.getMessage());
            
            
        }
    } 

        public void Xuat () throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException ex)
        {
            System.out.print("Loi: " + ex.getMessage());
        }
        //try{
               Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3333/demo2","root","01278587557");
               //Statement stm = conn.createStatement();
        //}// catch(SQLException se) {
           // System.err.println("Loi!!" + se.getMessage());
        //}
        
        CallableStatement stm = conn.prepareCall("{call ban(?)}");
        stm.registerOutParameter(1, Types.INTEGER);
        stm.execute();
        
        System.out.println("So luong : "+ stm.getInt(1));
        
        
        stm.close();
        conn.close();
    }
    
    
     
    public List<Ban> getDsb() {
        return dsb;
    }

   
    public void setDsb(List<Ban> dsb) {
        this.dsb = dsb;
    }
}
 */
