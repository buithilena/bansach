/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class DBContext {
    protected Connection conn;

    public Connection getConnect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
//          Hoanggggf
            String connectionUrl = "jdbc:sqlserver://HOANGGGGF\\SQLEXPRESS:1433;databaseName=thisIsBookStore;encrypt=false";            
            conn = DriverManager.getConnection(connectionUrl, "sa", "123");

            
            System.out.println("Kết nối cơ sở dữ liệu thành công !");
           
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Kết nối cơ sở dữ liệu thất bại !");
            System.out.println(0);
        }
         return conn;
    }
    
    public static void main(String[] args) {
        DBContext conn = new DBContext();
        conn.getConnect();
        
    }
}
