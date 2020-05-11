package com.niit.techno.crm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.techno.crm.model.Travel;
@Repository
public class TravelDAOImpl implements TravelDAO{
@Autowired
private SessionFactory sessionFactory;
	@Override
	public void saveTravel(Travel tUser) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(tUser);
	}

}
