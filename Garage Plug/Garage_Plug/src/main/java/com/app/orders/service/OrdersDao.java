package com.app.orders.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Customer;
import com.app.model.Orders;

@Repository
public interface OrdersDao extends JpaRepository<Orders, Integer> {
	
	public List<Orders> findByCustomers(Customer customers);
	
	
}
