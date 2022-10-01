package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Customer;
import com.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		List<Customer> customers = customerService.findAll();
		theModel.addAttribute("Customers", customers);
		return "list-customers";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForUpdate(Model theModel) {
		// create model attribute to bind form data
		Customer theCustomer = new Customer();
		theModel.addAttribute("Customer", theCustomer);
		return "customer-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		// get the Customer from the service
		Customer theCustomer = customerService.findById(theId);
		// set Customer as a model attribute to pre-populate the form
		theModel.addAttribute("Customer", theCustomer);
		return "customer-form";
	}

	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("first_name") String fName,
			@RequestParam("last_name") String lName, @RequestParam("email") String email,
			@RequestParam("mobile") String mobile) {

		System.out.println(id);
		Customer theCustomer;
		if (id != 0) {
			theCustomer = customerService.findById(id);
			theCustomer.setFirstName(fName);
			theCustomer.setLastName(lName);
			theCustomer.setEmail(email);
			theCustomer.setMobile(mobile);
		} else {
			theCustomer = new Customer(fName, lName, email, mobile);
		}
		// save the Customer
		customerService.save(theCustomer);

		// use a redirect to prevent duplicate submissions
		return "redirect:/customers/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("customerId") int theId) {

		// delete the Customer
		customerService.deleteById(theId);

		// redirect to /Customers/list
		return "redirect:/customers/list";
	}

	@RequestMapping("/search")
	public String search(@RequestParam("first_name") String firstName, 
			@RequestParam("last_name") String lastName, 
			@RequestParam("email") String email, 
			@RequestParam("mobile") String mobile, Model theModel) {

		// check names, if all fields are empty then just give list of all Customers

		if (firstName.trim().isEmpty() && lastName.trim().isEmpty() &&  
				email.trim().isEmpty() &&  mobile.trim().isEmpty() ) {
			return "redirect:/customers/list";
		}
		else {
			// else, search by first name, last name, email and mobile
			List<Customer> theCustomers = customerService.searchBy(firstName, lastName, email, mobile);

			// add to the spring model
			theModel.addAttribute("Customers", theCustomers);

			// send to list-Customers
			return "list-customers";
		}
	}

}
