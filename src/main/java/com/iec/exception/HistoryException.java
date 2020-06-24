package com.iec.exception;

public class HistoryException extends Exception{
	
	private static final long serialVersionUID = 4269316494280751012L;

	public HistoryException(final String message) {
		super(message);
	}

	public HistoryException(final String message, final Throwable throwable) {
		super(message, throwable);
	}

}
