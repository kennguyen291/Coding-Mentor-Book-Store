package coding.mentor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import coding.mentor.entity.Book;
import coding.mentor.util.MySqlDBConnector;

public class UserDAO {
	public boolean checkUserByPasswordAndUsername(String username, String password) {
		boolean isUser = false;
		Connection connection = MySqlDBConnector.makeConnection();
		System.out.println(connection);
		ResultSet rs = null;
		PreparedStatement ps = null;

		String sqlQuery = "SELECT * FROM `user` WHERE username = '" + username + "'AND password = '" + password + "'";
		
		try {
			ps = connection.prepareStatement(sqlQuery);
			rs = ps.executeQuery();
			
			if (rs.next() == true) {  
				isUser = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return isUser;
	}
}
