package com.landvibe.ttotto.log;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jboss.logging.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class RequestLogFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		ContentCachingRequestWrapper req = new ContentCachingRequestWrapper((HttpServletRequest) request);
		buildLogInfos(req);

		chain.doFilter(req, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException  {
		Filter.super.init(filterConfig);
	}

	@Override
	public void destroy() {
		Filter.super.destroy();
	}

	private void buildLogInfos(ContentCachingRequestWrapper request) throws IOException {
		Map<String, Object> requestInfos = Map.of(
			"transaction_id", UUID.randomUUID().toString(),
			"uri", request.getRequestURI(),
			"url", request.getRequestURL().toString(),
			"method", request.getMethod(),
			"headers", logRequestHeader(request),
			"parameters", logRequestParameter(request),
			"body", logRequestBody(request)
		);

		MDC.put("request", new ObjectMapper().writeValueAsString(requestInfos));
	}

	private HashMap<String, Object> logRequestHeader(ContentCachingRequestWrapper request) {
		HashMap<String, Object> headers = new HashMap<>();

		Enumeration<String> requestHeaderNameList = request.getHeaderNames();

		while (requestHeaderNameList.hasMoreElements()) {
			String headerName = requestHeaderNameList.nextElement();
			headers.put(headerName, request.getHeader(headerName));
		}

		return headers;
	}

	private HashMap<String, Object> logRequestParameter(ContentCachingRequestWrapper request) {
		HashMap<String, Object> parameters = new HashMap<>();

		request.getParameterMap().forEach((k, v) ->
			parameters.put(k, v[0])
		);

		return parameters;
	}

	private HashMap<String, Object> logRequestBody(ContentCachingRequestWrapper request) throws IOException {
		byte[] data = request.getContentAsByteArray();

		if (data.length == 0) return new HashMap<>();

		return new ObjectMapper().readValue(data, new TypeReference<>() {});
	}
}
