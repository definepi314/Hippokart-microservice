package com.cg.hippokart.dto;

/**
 * Error class used to set the application error code and description for
 * logging purpose
 * 
 * @author Sandesh Chauhan
 *
 */
public class Error {

	/** Field used to set the error code **/
	private String code;

	/** Field used to set error description **/
	private String description;

	/** Field is used to set additional information **/
	private String additionalInfo;

	/**
	 * Error constructor
	 */
	public Error() {

	}

	/**
	 * Error constructor
	 * 
	 * @param code
	 * @param description
	 */
	public Error(final String code, final String description) {
		super();
		this.code = code;
		this.description = description;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param code
	 * @param description
	 * @param additionalInfo
	 */
	public Error(String code, String description, String additionalInfo) {
		super();
		this.code = code;
		this.description = description;
		this.additionalInfo = additionalInfo;
	}

	/**
	 * Method used to get error code
	 * 
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Method used to set error code
	 * 
	 * @param code the code to set
	 */
	public void setCode(final String code) {
		this.code = code;
	}

	/**
	 * Method used to get error description
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Method used to set error description
	 * 
	 * @param description the description to set
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

	/**
	 * Method used to get error additional info
	 * 
	 * @return the additional info
	 */
	public String getAdditionalInfo() {
		return additionalInfo;
	}

	/**
	 * Method used to set error additional info
	 * 
	 * @param additionalInfo
	 */
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
}
