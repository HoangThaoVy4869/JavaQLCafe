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
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class ThanhToan {

    public void Tong() throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3333/qlqcafe", "root", "01278587557");

        String sql = "SELECT *,(giaDoAn*soLuongDoAn+giaDoUong*soLuongDoUong) as'tongtien' FROM goimon";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            System.out.println("HOA DON CUA BAN");
            System.out.printf("%s\n %s \n %s \n %d \n %d \n %s \n %f \n %s \n %s \n",
                    "MA BAN: " + rs.getString("maBan"),"TEN DO AN: "+ rs.getString("tenDoAn"),"TEN DO UONG: "+ rs.getString("tenDoUong"), 
                    rs.getInt("soLuongDoAn"), rs.getInt("soLuongDoUong"), rs.getBigDecimal("giaDoAn"),
                    rs.getBigDecimal("giaDoUong"), "NGAY THANH TOAN: "+ rs.getDate("ngaythanhtoan"),rs.getBigDecimal("tongtien"));
        }
        conn.close();
    }
    
        public void TrangThai() throws SQLException{
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3333/qlqcafe", "root", "01278587557");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui long nhap lai ma Ban da su dung: ");
        String maBan = scanner.nextLine();
        String sql = "update ban set tinhTrang='Trong' where maBan ='" + maBan + "'";
        Statement stmt = conn.prepareCall(sql);
        stmt.executeUpdate(sql);
        conn.close();
    }
    
    
}
