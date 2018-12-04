package servlet;

import dao.BooktDAO;
import dao.impl.BooktDAOimpl;
import domain.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "indexServlet",urlPatterns = "/index.do")
public class indexServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BooktDAO dao=new BooktDAOimpl();
		List<Book> booktList=null;
		List<Book> booksThisWeek=null;
		Book bookThisWeek=null;
		booktList=dao.getRecommadation(4);
		booksThisWeek=dao.getRecommthisweek(1);
		bookThisWeek=booksThisWeek.get(0);
		request.setAttribute("bList",booktList);
		request.setAttribute("bThis",bookThisWeek);
		request.getRequestDispatcher("/front/front.jsp").forward(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}
