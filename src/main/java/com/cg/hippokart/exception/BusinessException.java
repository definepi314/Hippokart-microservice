package com.cg.hippokart.exception;

import java.util.ArrayList;


import java.util.List;
import com.cg.hippokart.dto.Error;
import org.apache.commons.collections4.CollectionUtils;


/**
 * BusinessException - Application Exception class used to create
 * and throw user defined business exception in case of known Business Service Exception

 */
public class BusinessException extends WrapperRunTimeException {

	private static final long serialVersionUID = 2445778754521739604L;
	
	/**
	 * List contain the Error object , and it conatain the Error code which describe error type , 
	 * application, module and its description 	 */
	private List<Error> errors = new ArrayList<Error>();

	/**
	 * Default Constructor
	 */
	public BusinessException() {	
	}


    /**
     * Constructor with 
	 * @param message of type String
	 */
	public BusinessException(final String message) {
		super(message);
	}

	/**
	 * Constructor with 
	 * @param cause
	 */
	public BusinessException(final Throwable cause) {
		super(cause);
	}

	/** Constructor 
	 * @param message type String
	 * @param cause type Throwable
	 */
	public BusinessException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor with  
	 * @param message type String
	 * @param cause type Throwable 
	 * @param isexceptionLogged tyep boolean
	 */
	public BusinessException(final String message, final Throwable cause, boolean isexceptionLogged) {
		super(message, cause, isexceptionLogged);
	}

	/**
	 * Constructor with 
	 * @param message type String
	 * @param cause type Throwable
	 * @param isexceptionLogged type boolean
	 * @param errorList type List<Error>
	 */
	public BusinessException(final String message, final Throwable cause, boolean isexceptionLogged,
			List<Error> errorList) {
		super(message, cause, isexceptionLogged);
		setErrors(errorList);
	}

	/**
	 * Constructor with 
	 * @param message type String
	 * @param cause type Throwable
	 * @param enableSuppression type boolean
	 * @param writableStackTrace type boolean
	 */
	public BusinessException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}


	/**
	 * This method return the list of Error object 
	 * @return type List<Error>
	 */
	public List<Error> getErrors() {
		return errors;
	}

	/**
	 * This method used to set the application generated List of Error in Business Exception 
	 * @param errors type List<Error>
	 */
	public void setErrors(final List<Error> errors) {
		this.errors = errors;
	}

	/**
	 * This method used to set one by one Error object to Business Exception
	 * @param error type Error 
	 */
	public void addError(final Error error) {
		if (CollectionUtils.isNotEmpty(errors)) {
			this.errors.add(error);
		} else {
			this.errors = new ArrayList<Error>();
			this.errors.add(error);
		}
		
	}
}
