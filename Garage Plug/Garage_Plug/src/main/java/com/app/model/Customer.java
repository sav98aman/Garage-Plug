package com.app.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customer_id;
	
	
	private CustomerType Customer_Type;
	
	@Size(min=3,max = 26 ,message="Name size grater than 3 or less then 26")
	private String Customer_Name;
	
	@Size(min=10,max = 10 ,message="Please Enter correct phone Number")
	@Pattern(regexp="[6-9]{1}[0-9]{9}" ,message = "Please Enter correct phone Number")
	private String Customer_Phone;
	
	@Size(min=5,max=15,message = "password size must be min 3 and max 15")
	@Pattern(regexp="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$" ,message = "password should be combination of one-uppercase,one-lowwercase and special charcahter ")
	private String Password;
	
}
