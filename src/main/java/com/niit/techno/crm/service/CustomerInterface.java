package com.niit.techno.crm.service;

import java.util.List;

import com.niit.techno.crm.model.Customer;

public interface CustomerInterface {
public void saveCustomer(Customer theCust);
	public List<Customer> getCustomers();
	public Customer getCustomer(int theId);
	public void deleteCustomer(int theId);
}
