package com.app.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
	
	@Size(min=10,max = 10 ,message="Please Enter correct phone Number")
	@Pattern(regexp="[6-9]{1}[0-9]{9}" ,message = "Please Enter correct phone Number")
	private String phone_Number;
	private String password;
}
