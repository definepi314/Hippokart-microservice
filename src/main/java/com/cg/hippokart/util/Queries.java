package com.cg.hippokart.util;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Resource bundle class
 * @author Sandesh Chauhan
 */
public final class Queries {
	private static final Logger _LOGGER = LoggerFactory.getLogger(Queries.class);
	private static final String BUNDLE_NAME = "sql_query";
	private static final long VALUE1000 = 1000;
	private static final int VALUE_THOUSAND = 1000;

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private Queries() {
		// disallow construction
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
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException missingResourceException) {
			_LOGGER.error("Unable to implement getString method", missingResourceException);
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
	public static long getLong(String key) {
		try {
			return Long.parseLong(RESOURCE_BUNDLE.getString(key));
		} catch (MissingResourceException missingResourceException) {
			_LOGGER.error("Unable to implement getLong method", missingResourceException);
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
	public static int getInt(String key) {
		try {
			return Integer.parseInt(RESOURCE_BUNDLE.getString(key));
		} catch (MissingResourceException missingResourceException) {
			_LOGGER.error("Unable to implement getInt method", missingResourceException);
			return VALUE_THOUSAND;
		}
	}

	/**
	 * Get a message string
	 * 
	 * @param key
	 *            the key identifying the message
	 * @return An integer containing the message
	 */
	public static boolean getBoolean(String key) {
		try {
			return Boolean.parseBoolean(RESOURCE_BUNDLE.getString(key));
		} catch (MissingResourceException missingResourceException) {
			_LOGGER.error("Unable to implement getBoolean method", missingResourceException);
			return false;
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
	public static String getString(String key, Object... args) {
		try {
			MessageFormat formatter = new MessageFormat(RESOURCE_BUNDLE.getString(key));
			return formatter.format(args);
		} catch (MissingResourceException missingResourceException) {
			_LOGGER.error("Unable to implement getString method", missingResourceException);
			return '!' + key + '!';
		}
	}
}
