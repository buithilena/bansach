package DAO;

import context.DBContext;
import entity.Account;
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

    public Account Login(String username, String password) {
//        String query = "select * from Account";
        String query = "SELECT * FROM Account WHERE username = ? AND password = ?";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1),
                        rs.getString(2));
            }

        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        Dao test = new Dao();
        Account pro = test.Login("na", "123");
        System.out.println(pro);
    }

}
