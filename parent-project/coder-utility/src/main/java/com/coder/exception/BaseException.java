package com.coder.exception;

public class BaseException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;

	public BaseException(String message) {
		super(message);
		this.message = message;
	}

	public BaseException(Throwable cause) {
		super(cause);
	}

	public String getMessage() {
		return message;
	}

}
