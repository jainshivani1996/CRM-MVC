package com.niit.techno.crm.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.techno.crm.model.Customer;
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveCustomer(Customer theCust) {
		Session currentSession=
				sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCust);
	}


	public List<Customer> getCustomers() {
		Session session=
				sessionFactory.getCurrentSession();//jpql
		CriteriaBuilder cb=session.getCriteriaBuilder();
		CriteriaQuery<Customer> cq=cb.createQuery(Customer.class);//root references entity
		Root<Customer> root=cq.from(Customer.class);
		cq.select(root);
		Query query=session.createQuery(cq);
		return query.getResultList();
	}

	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		Session currentSession=
				sessionFactory.getCurrentSession();
		Customer theCustomer=currentSession.get(Customer.class,theId);
		return theCustomer;
	}


	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		Session session=
				sessionFactory.getCurrentSession();
		Customer book=session.byId(Customer.class).load(id);
		session.delete(book);
		
	}

}
