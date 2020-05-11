package com.niit.techno.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.techno.crm.dao.TravelDAO;
import com.niit.techno.crm.model.Travel;
@Service
public class TravelServiceImpl implements TravelService{

	@Autowired
	private TravelDAO travelDAO;

	@Override
	@Transactional
	public void saveTravel(Travel tUser) {

	travelDAO.saveTravel(tUser);
	}

}
