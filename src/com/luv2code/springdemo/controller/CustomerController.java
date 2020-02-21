package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String showHome(Model model) {
		List<Customer> theCustomers=customerService.getCustomers();
		System.out.println(theCustomers);
		model.addAttribute("customers", theCustomers);
		return "list-customers";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer theCustomer=new Customer();
		model.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/addCustomer")
	public String addCustomer(@ModelAttribute("customer") Customer customer) {
		System.out.println(customer.getFirstName());
		customerService.addCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateCustomer(@RequestParam("customerId") int theId, Model model) {
		Customer theCustomer = customerService.getCustomer(theId);
		model.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	@RequestMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int theId, Model model) {
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
	
	@RequestMapping("/searchCustomer")
	public String searchCustomer(@RequestParam("theSearchName") String theSearchName, Model model) {
		Customer customer = new Customer();
		List<Customer> theCustomers=customerService.searchCustomers(theSearchName);
		model.addAttribute("customers", theCustomers);
		return "list-customers";
	}

}
