package com.cg.hippokart.cors;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



/**
 * Filter to set headers for Angular requests.
 * 
 * @author 212421693
 *
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

	private static final String MESSAGE = "Getting Logged";
	private static final Logger _LOGGER = LoggerFactory.getLogger(CorsFilter.class);
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		// $NON-NLS-1$ //$NON-NLS-2$
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE ,PUT");
		// $NON-NLS-1$//$NON-NLS-2$
		response.setHeader("Access-Control-Max-Age", "3600");
		// $NON-NLS-1$ //$NON-NLS-2$
		response.setHeader("Access-Control-Allow-Headers",
				"Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization"); //$NON-NLS-1$
		// $NON-NLS-1$
		chain.doFilter(req, res);
	}

	public void destroy() {
		// Do nothing because of X and Y

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig arg0) throws ServletException {

		_LOGGER.info(MESSAGE + arg0);
	}

}
