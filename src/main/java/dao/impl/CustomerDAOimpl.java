package dao.impl;

import dao.CustomerDAO;
import domain.Customer;
import jdbc.jdbc.util.CRUDTmpl;
import jdbc.jdbc.util.IResultSetHandler;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOimpl implements CustomerDAO {
	@Override
	public List<Customer> queryCustomer() {
		return null;
	}

	@Override
	public boolean addCustomer(Customer customer) {
		boolean flag=false;
		if(customer==null) return flag;
		String sql="insert into customert(cust_no,cust_pwd value(?,?))";
		int intflag= CRUDTmpl.executeUpdate(sql,customer.getCustNo(),customer.getCustPwd());
		if(intflag==1) flag=true;
		return flag;
	}

	@Override
	public Customer getCustomer(String cusName) {
		String sql="select cust_id,cust_no,cust_pwd from customert where cust_no=?";
		IResultSetHandler<List<Customer>>rs=new customertResultSetImp();
		List<Customer>list=new ArrayList<>();
		list=CRUDTmpl.executeQuery(sql,rs,cusName);
		return list.size()==1?list.get(0):null;
	}

	@Override
	public Customer getCustomer(String cusName, String cusPwd) {
		String sql="select * from customert where cust_no=? and cust_pwd=?";
		IResultSetHandler<List<Customer>>rs=new customertResultSetImp();
		List<Customer>list=new ArrayList<>();
		list=CRUDTmpl.executeQuery(sql,rs,cusName,cusPwd);
		return list.size()==1?list.get(0):null;
	}

	@Override
	public boolean resetPwd(String cusName, String cusPwd) {
		boolean flag=false;
		String sql="update customert set pwd=? where cust_no=?";
		int intflag= CRUDTmpl.executeUpdate(sql,cusPwd,cusName);
		if(intflag==1) flag=true;
		return flag;
	}

	@Override
	public boolean updateCustomerHeaderImage(Customer customer) {
		boolean flag=false;
		String sql="update customert set cust_img=? where ";
		return flag;
	}
}
class customertResultSetImp implements IResultSetHandler<List<Customer>> {
	@Override
	public List<Customer> handler(ResultSet rs) throws Exception {
		List<Customer>list=new ArrayList<>();
		while (rs.next()){
			Customer c=new Customer();
			c.setSustId(rs.getInt(1));
			c.setCustNo(rs.getString(2));
			c.setCustPwd(rs.getString(3));
			c.setLastLogin(rs.getDate(4));
			c.setCustImg(rs.getString(5));
			c.setEmail(rs.getString(6));
			list.add(c);
		}
		return list;
	}
}
