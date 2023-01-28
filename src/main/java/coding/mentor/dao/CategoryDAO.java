package coding.mentor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import coding.mentor.entity.Category;
import coding.mentor.util.MySqlDBConnector;

public class CategoryDAO {
	public List<Category> getAllCategory(){
		List<Category> categoryList = new ArrayList<Category>();
		
		Connection connection = MySqlDBConnector.makeConnection();
		System.out.println(connection);
		ResultSet rs = null;
		PreparedStatement ps = null;

		String sqlQuery = "SELECT * FROM `category`";
		   
		try {
			ps = connection.prepareStatement(sqlQuery);
			rs = ps.executeQuery();
			
			while(rs.next() == true) {
				String name = rs.getString("name");
				
				Category category = new Category(name);
				categoryList.add(category);
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

		return categoryList;

	}
	
}
