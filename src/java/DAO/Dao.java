package DAO;

import context.DBContext;
import entity.Account;
import entity.Customers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author admin
 */
public class Dao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Customers Login(String customer_username, String customer_password) {
//        String query = "select * from Account";
        String query = "SELECT * FROM customers WHERE customer_username = ? AND customer_password = ?";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);
            
            ps.setString(1, customer_username);
            ps.setString(2, customer_password);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Customers(rs.getString(1),
                        rs.getString(2),
                rs.getString(3), 
                rs.getString(4),
                rs.getString(5), 
                rs.getString(6),
                rs.getString(7),
                rs.getBoolean(8));
            }

        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        Dao test = new Dao();
        Customers pro = test.Login("nvna@gmail.com", "123456789");
        System.out.println(pro);
    }

}
