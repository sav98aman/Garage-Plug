package com.app.orders.service;

import java.util.List;

import com.app.exception.CustomerException;
import com.app.exception.OrdersException;
import com.app.model.Orders;

public interface OrdersService {

	public Orders createOrders(String uuid ,Integer product_id) throws OrdersException,CustomerException;
	public List<Orders> GetOrdersDeatils(String uuid)throws OrdersException,CustomerException;
}
