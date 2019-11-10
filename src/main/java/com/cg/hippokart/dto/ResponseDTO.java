package com.cg.hippokart.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ResponseDTO implements Serializable{
	
	private static final long serialVersionUID = -2955405497277606189L;

	private String status;	
	private String request;
	private Object response;
	private List<Error> errors;
	
	/**
	 * 
	 */
	public ResponseDTO() {
		super();
	}
	
	/**
	 * 
	 * @param status
	 */
	public ResponseDTO(String status) {
		super();
		this.status = status;
		
	}
	
	

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the request
	 */
	public String getRequest() {
		return request;
	}

	/**
	 * @param request the request to set
	 */
	public void setRequest(String request) {
		this.request = request;
	}

	/**
	 * @return the response
	 */
	public Object getResponse() {
		return response;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(Object response) {
		this.response = response;
	}

	/**
	 * @return the error
	 */
	public List<Error> getErrors() {
		if(errors == null) {
			errors = new ArrayList<Error>();
		}
		
		return errors;
	}

	/**
	 * @param error the error to set
	 */
	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}
	
	public void addError(Error error) {
		if(errors == null) {
			errors = new ArrayList<Error>();
		}
		
		errors.add(error);
	}

	@Override
	public String toString() {
		return "ResponseDTO [status=" + status + ", request=" + request + ", response=" + response + ", error=" + errors
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((errors == null) ? 0 : errors.hashCode());
		result = prime * result + ((request == null) ? 0 : request.hashCode());
		result = prime * result + ((response == null) ? 0 : response.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponseDTO other = (ResponseDTO) obj;
		if (errors == null) {
			if (other.errors != null)
				return false;
		} else if (!errors.equals(other.errors))
			return false;
		if (request == null) {
			if (other.request != null)
				return false;
		} else if (!request.equals(other.request))
			return false;
		if (response == null) {
			if (other.response != null)
				return false;
		} else if (!response.equals(other.response))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
}
