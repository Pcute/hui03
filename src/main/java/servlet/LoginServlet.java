package servlet;

import dao.CustomerDAO;
import dao.impl.CustomerDAOimpl;
import domain.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uname=request.getParameter("name");
		String upwd=request.getParameter("pwd");
		CustomerDAO dao=new CustomerDAOimpl();
		Customer customer=new Customer();
		customer=dao.getCustomer(uname,upwd);
		if(customer!=null){
			HttpSession session=request.getSession();
			session.setAttribute("loginer",customer);
			//response.sendRedirect(request.getContextPath()+"/index.do");//地址重定向
			request.getRequestDispatcher("/front/front.jsp").forward(request,response);
		}
		else{
			request.setAttribute("loginName",uname);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/front/logerror.jsp");
			dispatcher.forward(request,response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
