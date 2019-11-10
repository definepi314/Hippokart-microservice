/**
 * 
 */
package com.cg.hippokart.exception;
import com.cg.hippokart.dto.Error;
/**
 * This is wrapping class for the Runtime Exception (and throw user defined runtime exception in case of 
 * known Business Service Exception) which contain Error code and description
 * @author Sandesh Chauhan
 *
 */
public class SystemException extends WrapperRunTimeException {

	private static final long serialVersionUID = 1628328278665285664L;

	/**
	 * Error object contain the ErrorCode and its description
	 */
	private Error error = new Error();


	/**
	 * Constructor - with no @param
	 */
	public SystemException() {
	}

	/** Constructor with 
	 * @param message -String
	 */
	public SystemException(final String message) {
		super(message);
	}

	/** Constructor with 
	 * @param cause -Throwable
	 */
	public SystemException(final Throwable cause) {
		super(cause);
	}

	/**  Constructor with 
	 * @param message -String
	 * @param cause -Throwable
	 */
	public SystemException(final String message, final Throwable cause) {
		super(message, cause);
	}
	
	/**  Constructor with 
	 * @param message -String
	 * @param cause -Throwable
	 * @param isexceptionLogged -boolean
	 */
	public SystemException(final String message, final Throwable cause , final boolean isExceptionLogged) {
		super(message, cause,isExceptionLogged);
	}

	/**  Constructor with 
	 * @param message -String
	 * @param cause -Throwable
	 * @param isexceptionLogged -boolean
	 * @param error -Error
	 */
	public SystemException(final String message, final Throwable cause, final boolean isExceptionLogged,
			final Error error) {
		super(message, cause, isExceptionLogged);
		setError(error);
	}
	
	/**  Constructor with 
	 * @param message - String
	 * @param cause -Throwable
	 * @param enableSuppression -boolean
	 * @param writableStackTrace -boolean
	 */
	public SystemException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * Method used to get the Error object of the thrown exception
	 * @return
	 */
	public Error getError() {
		return error;
	}

	/**
	 * Method used to set the Error Object for thrown exception
	 * @param error
	 */
	public void setError(final Error error) {
		this.error = error;
	}

}
