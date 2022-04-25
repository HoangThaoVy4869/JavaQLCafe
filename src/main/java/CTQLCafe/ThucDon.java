/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTQLCafe;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author USER
 */
public class ThucDon {
    public List<SanPham> findAll() throws SQLException {
        List<SanPham> ds = new ArrayList<>();
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3333/qlqcafe","root","01278587557");
           
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM sanpham");
                while (rs.next()){
                    int maSanPham = rs.getInt("maSanPham");
                    String tenSanPham = rs.getString("tenSanPham");
                    BigDecimal gia = rs.getBigDecimal("gia");
                  
                    System.out.printf("%d - %s - %s\n",maSanPham, tenSanPham,gia);  
                }
                stmt.close();
                conn.close();
        return ds;
    }
     
}
