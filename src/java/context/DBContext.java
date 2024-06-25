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
            String connectionurl = "jdbc:sqlserver://LAPTOP-HLRA9EFE\\SQLEXPRESS:1433; databaseName=bookstore; encrypt=false";
            conn = DriverManager.getConnection(connectionurl, "sa", "123456");
            System.out.println(1);
           
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Không thể kết nối tới CSDL");
            System.out.println(0);
        }
         return conn;
    }
    
}
