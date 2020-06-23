package com.iec.exception;

public class ActivityException extends RuntimeException{
	
	private static final long serialVersionUID = 4269316494280751012L;

	public ActivityException(final String message) {
		super(message);
	}

	public ActivityException(final String message, final Throwable throwable) {
		super(message, throwable);
	}

}
