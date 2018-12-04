package dao.impl;

import dao.CustomerDAO;
import domain.Customer;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerDAOimplTest {

	@Test
	public void getCustomer() {
		CustomerDAO dao=new CustomerDAOimpl();
		Customer customer=new Customer();
		customer=dao.getCustomer("zhouping","111111");
		assertNotNull(customer);
	}
}