package com.app.customer.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.CustomerException;
import com.app.model.CurrentSession;
import com.app.model.Customer;
import com.app.model.CustomerType;
import com.app.model.LoginDto;

import net.bytebuddy.utility.RandomString;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerdao;
	
	@Autowired
	private CurrentSessionDao currentsessiondao;
	
	@Override
	public Customer create_Customer(Customer customer) throws CustomerException {
		
		Customer IsCustomer_allReady=customerdao.findByCustomer_Phone(customer.getCustomer_Phone());
		if (IsCustomer_allReady != null) {
			throw new CustomerException("This Phone"+customer.getCustomer_Phone()+"  Is  Register  Please Login ");
		}
		customer.setCustomer_Type(CustomerType.REGULAR);// by Default;
		return customerdao.save(customer);
		
	}

	@Override
	public CurrentSession customer_Login(LoginDto logindto) throws CustomerException {
	
		//check User Is AlReady Login Or Not
		Customer is_Customer= customerdao.findByCustomer_Phone(logindto.getPhone_Number());
		
		if (is_Customer == null) {
			throw new CustomerException("Customer IS No Register this mobile Number " +logindto.getPhone_Number());	
		}		
		// check Customer is Login
		CurrentSession session= currentsessiondao.findByCustomer_id(is_Customer.getCustomer_id());
		
		if (session != null) {
			throw new CustomerException("Customer IS AllReady Login ");
		}
		// check password
		if(!is_Customer.getPassword().equals(logindto.getPassword())) {
			throw new CustomerException(" Password Is worng ");
		}
		// Create login session
		session=new CurrentSession();
		String key= RandomString.make(6);
		session.setTimestamp(LocalDateTime.now());
		session.setCustomer_id(is_Customer.getCustomer_id());
		session.setUuid(key);
		
		return currentsessiondao.save(session);
		
	}

	
	@Override
	public String logoutUser(String uuid) throws CustomerException{
		
		CurrentSession currentusersession=currentsessiondao.findByUuid(uuid);
		if (currentusersession==null) {
			throw new CustomerException(" Customer IS Not  Login Please Login First");
		}
		currentsessiondao.delete(currentusersession);
		
		return "Logout succesfully !";
	}

	@Override
	public Customer getCustomer(String uuid) throws CustomerException {
		
		CurrentSession session=currentsessiondao.findByUuid(uuid);
		if (session == null) {
			throw new CustomerException("uuid key Is Not valid Please Check once again");
		}
		return  customerdao.findById(session.getCustomer_id()).get();
		
	}
}
