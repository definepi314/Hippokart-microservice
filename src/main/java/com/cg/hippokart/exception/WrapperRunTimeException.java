package com.cg.hippokart.exception;

/**
 * WrapperRunTimeException - Application Exception class used to create and
 * throw user defined runtime exception in case of known Business Service
 * Exception
 * 
 * @author Sandesh Chauhan
 */
public class WrapperRunTimeException extends RuntimeException {

	private static final long serialVersionUID = 2974594314846274905L;

	// This flag used to check whether exception is logged by application or not
	private boolean isExceptionlogged;

	/**
	 * Default Constructor
	 */
	public WrapperRunTimeException() {
	}

	/**
	 * Constructor
	 * 
	 * @param message
	 */
	public WrapperRunTimeException(final String message) {
		super(message);
	}

	/**
	 * Constructor
	 * 
	 * @param cause
	 *            -Throwable
	 */
	public WrapperRunTimeException(final Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor
	 * 
	 * @param message -String
	 * @param cause -Throwable
	 */
	public WrapperRunTimeException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor
	 * 
	 * @param message
	 * @param cause
	 * @param isexceptionLogged
	 */
	public WrapperRunTimeException(final String message, final Throwable cause, final boolean isExceptionLogged) {
		super(message, cause);
		this.isExceptionlogged = isExceptionLogged;
	}

	/**
	 * Constructor
	 * 
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public WrapperRunTimeException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	/**
	 * Method return the true or false flag depend on exception is already
	 * logged or not
	 * 
	 * @return
	 */
	public boolean isExceptionlogged() {
		return isExceptionlogged;
	}

	/**
	 * Method use to set the exceptionLogged to true after sending message for log
	 * 
	 * @param isExceptionlogged
	 */
	public void setExceptionlogged(final boolean isExceptionlogged) {
		this.isExceptionlogged = isExceptionlogged;
	}

}
