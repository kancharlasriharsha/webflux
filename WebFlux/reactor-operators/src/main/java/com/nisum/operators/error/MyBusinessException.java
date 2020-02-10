package com.nisum.operators.error;

public class MyBusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String CUSTOM_MESSAGE = "MyBusinessException Message";
	
	public MyBusinessException() {
		super(CUSTOM_MESSAGE);
	}

	public MyBusinessException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MyBusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public MyBusinessException(String message) {
		super(message);
	}

	public MyBusinessException(Throwable cause) {
		super(CUSTOM_MESSAGE, cause);
	}
	
	

}
