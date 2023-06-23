package com.movie.exceptions;

import org.springframework.http.HttpStatus;

public class fortestException {

	private final String messageString;
	private final Throwable cause;
	private final HttpStatus status;
	public fortestException(String messageString, Throwable cause, HttpStatus status) {
		super();
		this.messageString = messageString;
		this.cause = cause;
		this.status = status;
	}
	public String getMessageString() {
		return messageString;
	}
	public Throwable getCause() {
		return cause;
	}
	public HttpStatus getStatus() {
		return status;
	}
	

}

