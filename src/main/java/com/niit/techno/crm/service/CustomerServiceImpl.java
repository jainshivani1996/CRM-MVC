package com.niit.techno.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.techno.crm.dao.CustomerDAO;
import com.niit.techno.crm.model.Customer;
@Service
public class CustomerServiceImpl implements CustomerInterface {
	@Autowired
	private CustomerDAO customerDAO;
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		customerDAO.saveCustomer(theCustomer);
		
	}
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}
	@Transactional
	public Customer getCustomer(int theId) {
		return customerDAO.getCustomer(theId);
	}
	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerDAO.deleteCustomer(theId);
		
	}

}
