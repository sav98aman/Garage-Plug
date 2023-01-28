package com.app.customer.service;

import com.app.exception.CustomerException;
import com.app.model.CurrentSession;
import com.app.model.Customer;
import com.app.model.LoginDto;

public interface CustomerService {

	public Customer create_Customer(Customer customer) throws CustomerException;
	public CurrentSession customer_Login(LoginDto logindto)throws CustomerException;
	public String logoutUser(String uuid) throws CustomerException;
	
	public Customer getCustomer(String uuid) throws CustomerException;
}
