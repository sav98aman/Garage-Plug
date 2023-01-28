package com.app.model;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer order_Id;
	
	@Column(name = "product_id")
	private Integer product_Id;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customers;
	
	@Column(name = "discount")
	private Integer discount_in_percent;
}
