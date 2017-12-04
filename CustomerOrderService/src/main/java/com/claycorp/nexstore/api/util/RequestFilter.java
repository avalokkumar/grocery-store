package com.claycorp.nexstore.api.util;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

@Component
public class RequestFilter implements Filter {
	private static String correlationId = "";
	private static String userMaskedId = "userMaskedId";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			userMaskedId = "userMaskedId";
			correlationId = httpRequest.getHeader("correlationId");
			System.out.println("correlationId(((("+correlationId);
			String mdcData = String.format("[userId:%s | correlationId:%s] ", userMaskedId, correlationId);
			MDC.put("mdcData", mdcData);
			chain.doFilter(request, response);
		} finally {
			MDC.clear();
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	public static String getRequestId() {
		return correlationId;
	}
}