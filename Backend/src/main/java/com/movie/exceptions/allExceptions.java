package com.movie.exceptions;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class allExceptions extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = {CustomException.class})
	public ResponseEntity<Object> handleBUsinessException(CustomException b){
		fortestException frException=new fortestException(b.getMessage(), b.getCause(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(frException,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= {NoSuchElementException.class})
	public ResponseEntity<String> nosuchElement(NoSuchElementException noEle){
		return new ResponseEntity<String>("No such value present please change value",HttpStatus.NOT_FOUND);
	}
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Object>("please change the Request methos type ",HttpStatus.NOT_FOUND);
	}
	
}
