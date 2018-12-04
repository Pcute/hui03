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

@WebServlet(name = "ResetServlet",urlPatterns = "/reset.do")
public class ResetServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cusName=request.getParameter("name");
		String cusPwd=request.getParameter("oldPWD");
		String newcusPwd=request.getParameter("newPWD");
		//验证原密码会否正确；
		Customer cus=null;
		CustomerDAO dao=new CustomerDAOimpl();
		cus=dao.getCustomer(cusName,cusPwd);
		if(cus==null){
			request.getRequestDispatcher("/personal/reseterror.jsp").forward(request,response);
			return;
		}
		boolean flag=false;
		flag=dao.resetPwd(cusName,newcusPwd);
		if(flag==true){
			request.getRequestDispatcher("/personal/resetok.jsp").forward(request,response);
		}
		else {
			request.getRequestDispatcher("/personal/reseterror.jsp").forward(request,response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
