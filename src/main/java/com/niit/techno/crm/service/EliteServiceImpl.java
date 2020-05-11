package com.niit.techno.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.techno.crm.dao.EliteDAO;
import com.niit.techno.crm.model.Address;
import com.niit.techno.crm.model.EliteUser;

@Service
public class EliteServiceImpl implements EliteService{
	@Autowired
	private EliteDAO eliteDAO;
	@Transactional
	public void saveECustomer(Address add) {
	// TODO Auto-generated method stub
	 eliteDAO.saveECustomer(add);
	}
	@Transactional
	public EliteUser checkUser(EliteUser theEUser) {
	return  eliteDAO.checkUser(theEUser);

}
}