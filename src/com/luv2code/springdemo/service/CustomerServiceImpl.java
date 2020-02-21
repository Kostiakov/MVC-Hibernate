package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {

		return customerDAO.getCustomers();
	}
	
	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		customerDAO.addCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		Customer theCustomer = customerDAO.getCustomer(theId);
		return theCustomer;
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerDAO.deleteCustomer(theId);
		
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		List<Customer> theCustomers = customerDAO.searchCustomers(theSearchName);
		return theCustomers;
	}

}
