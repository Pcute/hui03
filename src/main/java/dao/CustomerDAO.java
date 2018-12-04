package dao;

import domain.Customer;

import java.util.List;

public interface CustomerDAO {
	public List<Customer> queryCustomer();
	public boolean addCustomer(Customer customer);
	public Customer getCustomer(String cusName);
	public Customer getCustomer(String cusName,String cusPwd);
	public boolean resetPwd(String cusName,String cusPwd);
	public boolean updateCustomerHeaderImage(Customer customer);
}
