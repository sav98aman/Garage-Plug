package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.customer.service.CustomerServiceImpl;
import com.app.exception.CustomerException;
import com.app.model.CurrentSession;
import com.app.model.Customer;
import com.app.model.LoginDto;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl customerserviceimpl;
	
	
	@PostMapping(value = "/signup")
	public ResponseEntity<Customer> Signup_Customer_Handaller(@Valid @RequestBody Customer customer) throws CustomerException{
		Customer newCustomer= customerserviceimpl.create_Customer(customer);
		return new ResponseEntity<Customer>(newCustomer,HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<CurrentSession> Login_Customer_Handaller(@Valid @RequestBody LoginDto logindto) throws CustomerException{
		
		CurrentSession loginCustomer= customerserviceimpl.customer_Login(logindto);
		return new ResponseEntity<CurrentSession>(loginCustomer,HttpStatus.OK);
	}
	
	@PostMapping(value = "/logut/{uuid}")
	public ResponseEntity<String> LogOut_Customer_Handaller(@PathVariable String uuid) throws CustomerException{
		
		String logout= customerserviceimpl.logoutUser(uuid);
		return new ResponseEntity<String>(logout,HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/deatils/{uuid}")
	public ResponseEntity<Customer> GET_Customer_Deatils_Handaller(@PathVariable String uuid) throws CustomerException{
		
		Customer get_customer= customerserviceimpl.getCustomer(uuid);
		return new ResponseEntity<Customer>(get_customer,HttpStatus.OK);
	}
	
	
}
