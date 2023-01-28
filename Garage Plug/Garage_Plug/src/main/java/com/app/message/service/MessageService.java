package com.app.message.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService  {


	public void sendMail9() {
		// TODO Auto-generated method stub
		System.out.println("Sent mail to customer");
		System.out.println("You have placed 9 orders with us. Buy one more stuff and you will be\r\n"
				+ "promoted to Gold customer and enjoy 10% discounts!\"");
	}
	
	public void sendMail19() {
		// TODO Auto-generated method stub
		System.out.println("Sent mail to customer");
		System.out.println("You have placed 19 orders with us. Buy one more stuff and you will be\r\n"
				+ "promoted to PLATINUM customer and enjoy 20% discounts!\"");
	}
	

}
