package coding.mentor.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coding.mentor.dao.BookDAO;
import coding.mentor.dao.CategoryDAO;
import coding.mentor.entity.Book;
import coding.mentor.entity.Category;
import coding.mentor.util.MySqlDBConnector;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		
//		List<Book> bookList = Arrays.asList(
//				new Book("Book 1", "description 1"), 
//				new Book("Book 2", "description 2"), 
//				new Book("Book 3", "description 3")
//			
//		);
		MySqlDBConnector.makeConnection() ;
		CategoryDAO categoryDAO = new CategoryDAO();
		List<Category> categoryList = categoryDAO.getAllCategory();
		
		BookDAO bookDAO = new BookDAO();
		List<Book> bookList = bookDAO.getAll();
		
		request.setAttribute("bookList", bookList);
		request.setAttribute("categoryList", categoryList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
