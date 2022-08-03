package com.credifamilia.crud.controller;

public class ResponseBody<T> {
	
	private String message;
	private int statusCode;
	private T body;
	
	public ResponseBody(String message, T body, int statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.body = body;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
