package com.niit.techno.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.techno.crm.model.Customer;
import com.niit.techno.crm.service.CustomerInterface;
import java.util.List;
@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerInterface customerInterface;
	@GetMapping("/showForm")
	public String showFormForAdd(ModelMap theModel) {
	Customer theCust=new Customer();
	theModel.addAttribute("customer",theCust);
	return "customer-form";
	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCust) {
		customerInterface.saveCustomer(theCust);
		return "redirect:/customer/list";
	}
	@GetMapping("/list") // @GetMapping - method level , default GET method
	public String listCustomers(ModelMap theModel) {
	List<Customer> theCust = customerInterface.getCustomers();
	theModel.addAttribute("customers", theCust);
	return "list-customers";
	}
	@GetMapping("/updateForm") // @GetMapping - method level , default GET method
	public String showFormForUpdate(@RequestParam("customerId") int theId,ModelMap theModel) {
	Customer theCustomer = customerInterface.getCustomer(theId);
	theModel.addAttribute("customers", theCustomer);
	return "customer-form";
	}
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		customerInterface.deleteCustomer(theId);
		return "redirect:/customer/list";
		}
}