package coding.mentor.util;

import java.sql.Connection;

import java.sql.DriverManager;

public class MySqlDBConnector {

	public static Connection makeConnection() {
		Connection conn = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cm-bookstore?serverTimezone=Australia/Sydney", "book_store_admin", "123123");
			System.out.println(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
