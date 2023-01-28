package coding.mentor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import coding.mentor.entity.Book;

import coding.mentor.util.MySqlDBConnector;

public class BookDAO {
	public List<Book> getAll(){
		List<Book> bookList = new ArrayList<Book>();
		
		Connection connection = MySqlDBConnector.makeConnection();
		System.out.println(connection);
		ResultSet rs = null;
		PreparedStatement ps = null;

		String sqlQuery = "SELECT * FROM `book`";
		   
		try {
			ps = connection.prepareStatement(sqlQuery);
			rs = ps.executeQuery();
			
			while(rs.next() == true) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				int categoryId = rs.getInt("categoryId");
				Book book = new Book(id, categoryId, name, description);
				bookList.add(book);
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

		return bookList;

	}

	public Book getBookById(int id){
		Book book = null;
		
		Connection connection = MySqlDBConnector.makeConnection();
		System.out.println(connection);
		ResultSet rs = null;
		PreparedStatement ps = null;

		String sqlQuery = "SELECT * FROM `book` where id = " + id;
		   
		try {
			ps = connection.prepareStatement(sqlQuery);
			rs = ps.executeQuery();
			
			if (rs.next() == true) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				int categoryId = rs.getInt("categoryId");
				book = new Book(name, description, categoryId);
				
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

		return book;

	}
}
