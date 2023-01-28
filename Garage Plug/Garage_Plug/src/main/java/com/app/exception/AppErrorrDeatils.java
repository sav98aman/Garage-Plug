package com.app.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppErrorrDeatils {
	
	private LocalDateTime timestamp;//localDate ANdTime use
	private String message;// ErrorMeassage 
	private String desc;//Description 
}
