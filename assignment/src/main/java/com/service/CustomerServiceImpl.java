package com.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Customer;

@Repository
public class CustomerServiceImpl implements CustomerService{
	
	private SessionFactory sessionFactory;
	
	//Create session
	private Session session;
	
	@Autowired
	public CustomerServiceImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		}
		catch(HibernateException e){
			session=sessionFactory.openSession();			
		}
	}

	@Override
	@Transactional
	public List<Customer> findAll() {
		Transaction tx = session.beginTransaction();
		List<Customer> customers = session.createQuery("from Customer").list();
		tx.commit();
		return customers;
	}

	@Override
	@Transactional
	public Customer findById(int theId) {
		Customer customer = new Customer();
		Transaction tx = session.beginTransaction();
		customer = session.get(Customer.class, theId);
		tx.commit();
		return customer;
	}

	@Override
	@Transactional
	public void save(Customer theCustomer) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(theCustomer);
		tx.commit();
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, theId);
		session.delete(customer);
		tx.commit();		
	}

	@Override
	@Transactional
	public List<Customer> searchBy(String firstName, String lastName, String email, String mobile) {
		Transaction tx = session.beginTransaction();
		String query = "";
		
		if(firstName.length()!=0 && lastName.length()!=0 && 
				email.length()!=0 && mobile.length()!=0) {
			query = "from Customer where first_name like '%"+firstName+"%' or last_name like '%"+
				lastName+"%' or email like '%"+email+"%' or mobile like '%"+mobile+
				"%'";
		}
		
		else if(firstName.length()!=0 && lastName.length()!=0 && 
				email.length()!=0) {
			query = "from Customer where first_name like '%"+firstName+"%' or last_name like '%"+
					lastName+"%' or email like '%"+email+"%'";
		}
		
		else if(firstName.length()!=0 && email.length()!=0 && 
				mobile.length()!=0) {
			query = "from Customer where first_name like '%"+firstName+"%'or email like '%"+
					email+"%' or mobile like '%"+mobile+"%'";
		}
		
		else if(lastName.length()!=0 && email.length()!=0 && 
				mobile.length()!=0) {
			query = "from Customer where last_name like '%"+lastName+"%' or email like '%"+
					email+"%' or mobile like '%"+mobile+"%'";
		}
		
		else if(firstName.length()!=0 && lastName.length()!=0) {
			query = "from Customer where first_name like '%"+firstName+"%' or last_name like '%"+
					lastName+"%'";
		}
		
		else if(firstName.length()!=0 && email.length()!=0) {
			query = "from Customer where first_name like '%"+firstName+"%' or email like '%"+
					email+"%'";
		}
		
		else if(firstName.length()!=0 && mobile.length()!=0) {
			query = "from Customer where first_name like '%"+firstName+"%'or mobile like '%"+
					mobile+"%'";
		}
		
		else if(lastName.length()!=0 && email.length()!=0) {
			query = "from Customer where last_name like '%"+lastName+"%' or email like '%"+
					email+"%'";
		}
		
		else if(lastName.length()!=0 && mobile.length()!=0) {
			query = "from Customer where last_name like '%"+lastName+"%' or mobile like '%"+
					mobile+"%'";
		}
		
		else if(email.length()!=0 && mobile.length()!=0) {
			query = "from Customer where email like '%"+email+"%' or mobile like '%"+
					mobile+"%'";
		}
		
		else if(firstName.length()!=0) {
			query = "from Customer where first_name like '%"+firstName+"%'";
		}
		
		else if(lastName.length()!=0) {
			query = "from Customer where last_name like '%"+lastName+"%'";
		}
		
		else if(email.length()!=0) {
			query = "from Customer where email like '%"+email+"%'";
		}
		
		else if(mobile.length()!=0) {
			query = "from Customer where mobile like '%"+mobile+"%'";
		}
		List<Customer> customers = session.createQuery(query).list();
		
		tx.commit();
		
		return customers;
	}

}
