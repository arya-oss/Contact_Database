package database;

import java.sql.*;
import java.util.logging.*;

/**
 * @author Rajmani Arya
 */
public class DataBase {
    private static DataBase instance=null;
    private Connection conn;
    private DataBase() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shubhayatra", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Connection getConnection() {
        if(instance == null) {
            instance = new DataBase();
        }
        return instance.conn;
    }
    public static void main(String[] args) throws SQLException {
        Connection conn = DataBase.getConnection();
        conn.close();
        System.out.println("Connected !");
    }
}
