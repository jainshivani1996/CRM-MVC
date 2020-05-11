package com.niit.techno.crm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.techno.crm.model.Address;
import com.niit.techno.crm.model.Elite;
import com.niit.techno.crm.model.EliteUser;
import com.niit.techno.crm.service.EliteService;

@Controller
@RequestMapping("/elite")
public class EliteController {
	@Autowired
	EliteService eliteService;
	@GetMapping("/regForm")
	public String showFormStringForAdd(ModelMap theModel)
	{
		Elite theCustomer=new Elite();
		theModel.addAttribute("elite",theCustomer);
		return "elite-form";
	}
	@PostMapping("/saveECustomer")
	public String saveEliteCustomer(HttpServletRequest req,@ModelAttribute("ecustomer")Elite theElite) {
		String s=req.getParameter("street");
		String c=req.getParameter("city");
		int p=Integer.parseInt(req.getParameter("pincode"));
		Address a=new Address();
		a.setStreet(s);
		a.setCity(c);
		a.setPincode(p);
		a.setElite(theElite);
		eliteService.saveECustomer(a);
		return "login-elite";
	}
	@RequestMapping(value = "/loginECustomer",  method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView processLogin(@ModelAttribute EliteUser theEUser) {
	EliteUser eusr = eliteService.checkUser(theEUser);
	ModelAndView model = null;
	if (eusr == null) {
	model = new ModelAndView("login-elite");
	model.addObject("error", "Invalid Username or Password");
	} else {
	model = new ModelAndView("welcomeElite");
	model.addObject("eusr", eusr);
	//model.addObject("usr", usr.getEmail());
	}
	return model;
	}
}
