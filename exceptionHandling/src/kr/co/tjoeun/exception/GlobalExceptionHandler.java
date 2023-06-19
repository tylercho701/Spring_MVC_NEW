package kr.co.tjoeun.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NullPointerException.class)
	public String nullPointerException() {
		
		return "global_null_pointer_exception";
	}
	
	@ExceptionHandler(Exception.class)
	public String exception() {
		
		return "global_exception1";
	}
}