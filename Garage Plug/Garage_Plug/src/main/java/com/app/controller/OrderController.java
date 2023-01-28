package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.CustomerException;
import com.app.exception.OrdersException;
import com.app.model.Orders;
import com.app.orders.service.OrdersServiceImpl;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
	
	@Autowired
	private OrdersServiceImpl  ordersserviceimpl;
	
	@PostMapping(value = "/create/{uuid}/{product_ID}")
	public ResponseEntity<Orders> create_Orders_Handaller(@PathVariable String uuid, @PathVariable Integer product_ID) throws OrdersException, CustomerException{
		Orders new_Orders= ordersserviceimpl.createOrders(uuid, product_ID);
		return new ResponseEntity<Orders>(new_Orders,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAll/{uuid}")
	public ResponseEntity<List<Orders>> GETALl_Orders_Handaller(@PathVariable String uuid) throws OrdersException, CustomerException{
		List<Orders> getallOrders= ordersserviceimpl.GetOrdersDeatils(uuid);
		return new ResponseEntity<List<Orders>>(getallOrders,HttpStatus.OK);
	}
	
}



