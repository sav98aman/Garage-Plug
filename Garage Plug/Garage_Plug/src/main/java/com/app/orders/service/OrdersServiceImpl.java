package com.app.orders.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customer.service.CurrentSessionDao;
import com.app.customer.service.CustomerDao;
import com.app.customer.service.CustomerServiceImpl;
import com.app.exception.CustomerException;
import com.app.exception.OrdersException;
import com.app.message.service.MessageService;
import com.app.model.CurrentSession;
import com.app.model.Customer;
import com.app.model.CustomerType;
import com.app.model.Orders;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersDao ordersdao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private CurrentSessionDao currentsessiondao;
	@Autowired
	private MessageService messageservice;
	@Autowired
	private CustomerServiceImpl customerserviceimpl;
	
	@Override
	public Orders createOrders(String uuid, Integer product_id) throws OrdersException, CustomerException {
		//check customer is vaild or not
		Customer customer=customerserviceimpl.getCustomer(uuid);
		//get orders of each customer
		List<Orders> customer_Orders_List=GetOrdersDeatils(uuid);

		Integer ordersize=customer_Orders_List.size();
		
		// create new Order according the product_ID (This Time Is Given By defaults Taking As Parameter)
		Orders orders=new Orders();
		orders.setCustomers(customer);
		orders.setProduct_Id(product_id);
		
		//get DIscount According TO Type Of Customer Like REGULAR-0% ,GLOD-10% And PALITNUM-20%
		if(ordersize>=10 && ordersize<=19) {
			orders.setDiscount_in_percent(10);
			
		}else if(ordersize>=20) {
			orders.setDiscount_in_percent(20);
		}else {
			orders.setDiscount_in_percent(0);
		}
		
		//Dummy Message Logic Like TO ACCORING TO GLOD MEMBER AND PALTINUM
		if(ordersize==9) {
			messageservice.sendMail9();
			
		}
		if(ordersize==19) {
			messageservice.sendMail19();
		}
		
		// IF DONE 10 ORDER SET REGULAR TYPE TO GLOD AND IF YOU DONE 20 ORDER THEN SET GLOD TO PALTINUM MEMBER
		if(ordersize==10) {
			// update to customer gold
			customer.setCustomer_Type(CustomerType.GOLD);
		}
		if(ordersize==20) {
			// update to customer Paltinum
			customer.setCustomer_Type(CustomerType.PLATINUM);
		}
		
		// Placed FINAL ORDERS AND Save ORder In Database
		return ordersdao.save(orders);
	}

	
	@Override
	public List<Orders> GetOrdersDeatils(String uuid) throws OrdersException, CustomerException {
		//user check
		Customer customer=customerserviceimpl.getCustomer(uuid);
		
		// find the no of orders each customers
		List<Orders> customer_Orders_List=ordersdao.findByCustomers(customer);
		return customer_Orders_List;
	}

}
