/**
 * 
 */
package com.cg.hippokart.util;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Sandesh Chauhan
 * This class contains methods used for exception 
 * handling across the application
 */
public class ExceptionsUtil {

	private static final String BUNDLE_NAME_MESSAGE = "exception-message";
	private static final String BUNDLE_NAME_CODE_TYPE = "exception-type";

	private static final long VALUE1000 = 1000;
	private static final int VALUE_THOUSAND = 1000;

	private static final ResourceBundle RESOURCE_BUNDLE_MESSAGE = ResourceBundle.getBundle(BUNDLE_NAME_MESSAGE);
	private static final ResourceBundle RESOURCE_BUNDLE_CODE_TYPE = ResourceBundle.getBundle(BUNDLE_NAME_CODE_TYPE);

	public ExceptionsUtil() {
	}

	/**
	 * Get a message string
	 * 
	 * @param key
	 *            the key identifying the message
	 * @return A string containing the message
	 */
	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE_MESSAGE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	/**
	 * Get a message string
	 * 
	 * @param key
	 *            the key identifying the message
	 * @return A string containing the message
	 */
	public long getLong(String key) {
		try {
			return Long.parseLong(RESOURCE_BUNDLE_MESSAGE.getString(key));
		} catch (MissingResourceException e) {
			return VALUE1000;

		}
	}

	/**
	 * Get a message string
	 * 
	 * @param key
	 *            the key identifying the message
	 * @return An integer containing the message
	 */
	public int getInt(String key) {
		try {
			return Integer.parseInt(RESOURCE_BUNDLE_MESSAGE.getString(key));
		} catch (MissingResourceException e) {
			return VALUE_THOUSAND;
		}
	}

	/**
	 * Build a formated string from the resource bundle.
	 * 
	 * @param key
	 *            the key into the resource bundle that has the formated string.
	 * @param args
	 *            an array of arguments
	 * @return the formated string with the arguments in-line.
	 */
	public String getString(String key, Object... args) {
		try {
			MessageFormat formatter = new MessageFormat(RESOURCE_BUNDLE_MESSAGE.getString(key));
			return formatter.format(args);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	/**
	 * @param exception
	 * @return name of the exception 
	 */
	public static String getExceptionName(final Throwable exception) {

		if (exception == null) {
			return StringUtils.EMPTY;
		}

		final String fullyQualifiedName = getFullQualifiedExceptionName(exception);

		final String exceptionName = StringUtils.substring(fullyQualifiedName,
				StringUtils.lastIndexOf(fullyQualifiedName, Constants.CHAR_PERIOD) + 1,
				StringUtils.length(fullyQualifiedName));

		return StringUtils.lowerCase(exceptionName);
	}

	/**
	 * @param exception
	 * @return the full qualified name of the exception
	 */
	public static String getFullQualifiedExceptionName(final Throwable exception) {
		final String fullyQualifiedName;
		if (exception.getCause() != null) {
			fullyQualifiedName = exception.getCause().getClass().getName();
		} else {
			fullyQualifiedName = exception.getClass().getName();
		}
		return StringUtils.lowerCase(fullyQualifiedName);
	}

	/**
	 * @param exception
	 * @return the type of exception as defined in properties file
	 */
	public static String getExceptionType(final Throwable exception) {
		final String exceptionCode = getFullQualifiedExceptionName(exception);
		try {
			return RESOURCE_BUNDLE_CODE_TYPE.getString(exceptionCode);
		} catch (MissingResourceException e) {
			return '!' + "NOT FOUND" + '!';
		}
	}

	/**
	 * @param exceptionName
	 * @param exceptionType
	 * @return the error code generated for the exception
	 */
	public static String generateErrorCode(final String exceptionName, final String exceptionType) {

		final StringBuffer errorCode = new StringBuffer(108);
		errorCode.append(exceptionType).append(Constants.CHAR_UNDERSCORE).append(exceptionName);

		return StringUtils.lowerCase(errorCode.toString());
	}
}
