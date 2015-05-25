import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Rajmani Arya
 * @see www.rajmani1995.blogspot.com
 */
public class DatabaseConnection implements DbConfig {
	private static DatabaseConnection instance=null;
	private Connection conn;
	public static Connection getInstance() {
		if(instance==null)
			instance = new DatabaseConnection();
		return instance.conn;
	}
	private DatabaseConnection() {
		String dburl = "jdbc:mysql://"+Host+":"+Port+"/"+Database;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, User, Password);
		} catch (ClassNotFoundException e ) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Connection conn = DatabaseConnection.getInstance();
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("connected !");
	}
}
