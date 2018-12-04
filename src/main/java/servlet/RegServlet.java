package servlet;

import dao.CustomerDAO;
import dao.impl.CustomerDAOimpl;
import domain.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegServlet",urlPatterns = "/reg.do")
public class RegServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cusName=request.getParameter("name");
		String cusPwd=request.getParameter("pwd");
		if(cusName!=null&&cusName.trim().equals("")&&cusPwd!=null&&cusPwd.trim().equals("")){
			request.setAttribute("loginName","用户名或者密码为空");
			request.getRequestDispatcher("/front/regerror.jsp").forward(request,response);
		}
		CustomerDAO dao=new CustomerDAOimpl();
		Customer customer=new Customer();
		customer.setCustNo(cusName);
		customer.setCustPwd(cusPwd);
		boolean flag=false;
		Customer cus=new Customer();
		cus=dao.getCustomer(cusName);
		if(cus!=null){
			request.setAttribute("loginName","用户名已经存在");
			request.getRequestDispatcher("/front/regerror.jsp").forward(request,response);
			return;
		}
		flag=dao.addCustomer(customer);
		if(flag==true){
			request.setAttribute("loginName",cusName);
			request.getRequestDispatcher("/front/regok.jsp").forward(request,response);
		}
		else {
			request.setAttribute("loginName",cusName);
			request.getRequestDispatcher("/front/regerror.jsp").forward(request,response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
