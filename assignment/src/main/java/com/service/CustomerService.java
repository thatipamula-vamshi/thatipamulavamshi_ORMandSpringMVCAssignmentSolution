package com.service;

import java.util.List;

import com.entity.Customer;

public interface CustomerService {
	
	public  List<Customer> findAll();
	
	public Customer findById(int theId);
	
	public void save(Customer theCustomer);
	
	public void deleteById(int theId);
	
	public List<Customer> searchBy(String firstName,String lastName, String email, String mobile);

}
