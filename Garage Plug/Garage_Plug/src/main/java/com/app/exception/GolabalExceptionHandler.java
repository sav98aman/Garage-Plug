package com.app.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GolabalExceptionHandler {
	
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<AppErrorrDeatils> CustomerExceptionHandaller(CustomerException ex,WebRequest req){
		
		AppErrorrDeatils err=new AppErrorrDeatils(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<AppErrorrDeatils>(err,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(OrdersException.class)
	public ResponseEntity<AppErrorrDeatils> ExceptionHandaller(OrdersException ex,WebRequest req){
		
		AppErrorrDeatils err=new AppErrorrDeatils(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<AppErrorrDeatils>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<AppErrorrDeatils> myMANVExceptionHandler(MethodArgumentNotValidException me) {
		AppErrorrDeatils err=new AppErrorrDeatils(LocalDateTime.now(),"Validation Error",me.getBindingResult().getFieldError().getDefaultMessage());
	return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<AppErrorrDeatils> ExceptionHandaller(CustomerException ex,WebRequest req){
		
		AppErrorrDeatils err=new AppErrorrDeatils(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<AppErrorrDeatils>(err,HttpStatus.BAD_REQUEST);
		
	}
}
