/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTQLCafe;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author USERs
 */
public class GoiMon {

    public void DatBan() throws SQLException {

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3333/qlqcafe", "root", "01278587557");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma Ban: ");
        String maBan = scanner.nextLine();
        TrangThai();
        System.out.println("Ten DoAn: ");
        String tenDoAn = scanner.nextLine();
        System.out.println("Ten Do Uong:");
        String tenDoUong = scanner.nextLine();
        System.out.println("Gia Do An: ");
        BigDecimal giaDoAn = scanner.nextBigDecimal();
        System.out.println("Gia Do Uong: ");
        BigDecimal giaDoUong = scanner.nextBigDecimal();
        System.out.println("So luong do an: ");
        int soLuongDoAn = scanner.nextInt();
        System.out.println("So luong do uong: ");
        int soLuongDoUong = scanner.nextInt();
        System.out.println("Ngay thanh toan: ");
        String ngaythanhtoan = scanner.next();

        String sql = "insert into goimon(maBan,tenDoAn,tenDoUong,giaDoAn,giaDoUong,soLuongDoAn,soLuongDoUong,ngaythanhtoan) values('" + maBan + "','" + tenDoAn + "','" + tenDoUong + "','" + giaDoAn + "','" + giaDoUong + "','" + soLuongDoAn + "','" + soLuongDoUong + "','" + ngaythanhtoan + "')";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.executeUpdate();
        conn.close();
    }

    public void Luu() throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3333/qlqcafe", "root", "01278587557");

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM goimon");

        while (rs.next()) {
            String maBan = rs.getString("maBan");
            String tenDoAn = rs.getString("tenDoAn");
            String tenDoUong = rs.getString("tenDoUong");
            int soLuongDoAn = rs.getInt("soLuongDoAn");
            int soLuongDoUong = rs.getInt("soLuongDoUong");
            BigDecimal giaDoAn = rs.getBigDecimal("giaDoAn");
            BigDecimal giaDoUong = rs.getBigDecimal("giaDouong");
            Date ngaythanhtoan = rs.getDate("ngaythanhtoan");
            System.out.printf("%s - %s - %s - %d - %d - %f - %f - %s\n", maBan, tenDoAn, tenDoUong, soLuongDoAn,soLuongDoUong,giaDoAn,giaDoUong,ngaythanhtoan);
        }
        stmt.close();
        conn.close();

    }

    public void TrangThai() throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3333/qlqcafe", "root", "01278587557");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui long nhap lai ma Ban vua chon: ");
        String maBan = scanner.nextLine();
        String sql = "update ban set tinhTrang='Da dat' where maBan ='" + maBan + "'";
        Statement stmt = conn.prepareCall(sql);
        stmt.executeUpdate(sql);
        conn.close();
    }
}
