/**
 * 
 */
package com.cg.hippokart.exceptionhandler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.hippokart.dto.ResponseDTO;
import com.cg.hippokart.exception.BusinessException;
import com.cg.hippokart.exception.SystemException;
import com.cg.hippokart.exception.WrapperRunTimeException;
import com.cg.hippokart.util.Constants;
import com.cg.hippokart.util.ExceptionsUtil;
import com.cg.hippokart.dto.Error;
/**
 * @author Sandesh Chauhan
 *
 */
@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

	private static final Logger _LOGGER = LoggerFactory.getLogger(ExceptionHandlerControllerAdvice.class);

	/**
	 * @param request
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(BusinessException.class)
	public @ResponseBody ResponseDTO handleBusinessException(HttpServletRequest request, BusinessException exception) {

		_LOGGER.debug(" Entering BusinessException handler method  : handleBusinessException()");
		ResponseDTO responseDTO = new ResponseDTO(Constants.STATUS_FAILURE);
		final Error error = new Error();

		exception.setExceptionlogged(Boolean.TRUE);
		error.setCode(Constants.BUSINESS_EXCEPTION);
		error.setDescription(exception.getMessage());
		error.setAdditionalInfo("***");

		responseDTO.addError(error);
		_LOGGER.debug(" Exiting BusinessException handler method");

		return responseDTO;
	}

	/**
	 * @param request
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(SystemException.class)
	public @ResponseBody ResponseDTO handleSystemException(HttpServletRequest request, SystemException exception) {

		_LOGGER.debug(" Entering SystemException handler method : handleSystemException()");
		ResponseDTO responseDTO = new ResponseDTO(Constants.STATUS_FAILURE);
		final Error error = new Error();

		if (exception.getCause() != null) {

			final String exceptionName = ExceptionsUtil.getExceptionName(exception.getCause());
			final String exceptionType = ExceptionsUtil.getExceptionType(exception.getCause());
			final String exceptionCode = ExceptionsUtil.generateErrorCode(exceptionName, exceptionType);

			exception.setExceptionlogged(Boolean.TRUE);
			error.setCode(exceptionCode);
			error.setDescription(ExceptionsUtil.getString(exceptionCode));
			error.setAdditionalInfo("***");

		}
		responseDTO.addError(error);
		_LOGGER.debug(" Exiting SystemException handler method");

		return responseDTO;
	}

	/**
	 * @param request
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(Throwable.class)
	public @ResponseBody ResponseDTO handleException(HttpServletRequest request, Throwable exception) {

		_LOGGER.debug(" Entering Throwable Exception handler method : handleException()");
		ResponseDTO responseDTO = new ResponseDTO(Constants.STATUS_FAILURE);
		WrapperRunTimeException wrapperRunTimeException = new WrapperRunTimeException(exception);

		final Error error = new Error();

		if (exception.getCause() != null) {

			final String exceptionName = ExceptionsUtil.getExceptionName(exception.getCause());
			final String exceptionType = ExceptionsUtil.getExceptionType(exception.getCause());
			final String exceptionCode = ExceptionsUtil.generateErrorCode(exceptionName, exceptionType);

			error.setCode(exceptionCode);
			error.setDescription(ExceptionsUtil.getString(exceptionCode));

		} else {
			error.setDescription(exception.getMessage());
		}
		
		error.setAdditionalInfo("***");
		wrapperRunTimeException.setExceptionlogged(true);
		responseDTO.addError(error);
		_LOGGER.debug(" Exiting Throwable Exception handler method");
		return responseDTO;

	}

}
