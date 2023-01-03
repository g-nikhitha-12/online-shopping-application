package com.cg.osa.exception;

import java.time.LocalDateTime;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;





@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ProductException.class)
	public @ResponseBody ErrorInfo productIdException(ProductException e,HttpServletRequest req) {
	  
		String msg=e.getMessage();
		String uri= req.getRequestURI();
		return new ErrorInfo(msg,uri,LocalDateTime.now());
		
	}
	@ExceptionHandler(CustomerException.class)
	public @ResponseBody ErrorInfo CustomerIdException(CustomerException e,HttpServletRequest req) {
	  
		String msg=e.getMessage();
		String uri= req.getRequestURI();
		return new ErrorInfo(msg,uri,LocalDateTime.now());
		
	}
	@ExceptionHandler(CategoryException.class)
	public @ResponseBody ErrorInfo CategoryIdException(CategoryException e,HttpServletRequest req) {
		String msg=e.getMessage();
		String uri=req.getRequestURI();
		return new ErrorInfo(msg,uri,LocalDateTime.now());
	}
	@ExceptionHandler(CartException.class)
	public @ResponseBody ErrorInfo CartIdException(CartException e,HttpServletRequest req) {
		String msg=e.getMessage();
		String uri=req.getRequestURI();
		return new ErrorInfo(msg,uri,LocalDateTime.now());
	}
	@ExceptionHandler(OrderException.class)
	public @ResponseBody ErrorInfo OrderIdException(OrderException e,HttpServletRequest req) {
		
		String msg = e.getMessage();
		String uri = req.getRequestURI();
		return new ErrorInfo (msg,uri,LocalDateTime.now());
	
	}
	@ExceptionHandler(AddressException.class)
	public @ResponseBody ErrorInfo viewAddress(AddressException e,HttpServletRequest req)
	{
		String msg=e.getMessage();
		String uri= req.getRequestURI();
		return new ErrorInfo(msg,uri,LocalDateTime.now());
	}
	@ExceptionHandler(UserException.class)
	public @ResponseBody ErrorInfo viewUser(UserException e,HttpServletRequest req)
	{
		String msg=e.getMessage();
		String uri=req.getRequestURI();
		return new ErrorInfo(msg,uri,LocalDateTime.now());
	}
	
}
