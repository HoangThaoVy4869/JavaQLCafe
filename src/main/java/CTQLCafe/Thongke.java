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
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Thongke {
        public void statistical() throws SQLException {
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3333/qlqcafe","root","01278587557");
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui long nhap vao thang ban muon thong ke: ");
        String thang = scanner.next();
        String sql = "SELECT *,SUM(giaDoAn*soLuongDoAn+giaDoUong*soLuongDoUong) as'thongke' FROM goimon WHERE MONTH(ngayThanhToan) ="+thang;
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            System.out.println("THONG KE DOANH THU THEO THANG LA");
            System.out.printf("%s - %s\n",
                    "THANG: "+ thang ,rs.getBigDecimal("thongke"));
        }
    }
}
