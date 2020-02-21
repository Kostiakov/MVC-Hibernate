package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {

		//get session
		Session currSession = sessionFactory.getCurrentSession();
		//create query
		Query<Customer> theQuery = currSession.createQuery("from Customer order by lastName", Customer.class);
		//execute query
		List<Customer> customers = theQuery.getResultList();
		//return results
		return customers;
	}
	
	@Override
	public void addCustomer(Customer customer) {
		Session currSession = sessionFactory.getCurrentSession();
		currSession.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int theId) {
		Session currSession = sessionFactory.getCurrentSession();
		Customer theCustomer = currSession.get(Customer.class, theId);
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		Session currSession = sessionFactory.getCurrentSession();
		Customer theCustomer = currSession.get(Customer.class, theId);
		currSession.delete(theCustomer);
	}

	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		Session currSession= sessionFactory.getCurrentSession();
		Query theQuery = currSession.createQuery("from Customer where lastName=:theSearchName", Customer.class);
		theQuery.setParameter("theSearchName", theSearchName);
		List<Customer> theCustomers=theQuery.getResultList();
		return theCustomers;
	}

}
