package com.landvibe.ttotto.exception;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.Map;

public class UnauthorizedException extends TtoTtoException {

	public UnauthorizedException(String message, Integer code, String logMessage, Map<String, Object> additionalInfos) {
		super(HttpStatus.UNAUTHORIZED, message, code, logMessage, additionalInfos);
	}

	public UnauthorizedException(String message, Integer code, String logMessage) {
		super(HttpStatus.UNAUTHORIZED, message, code, logMessage, Collections.emptyMap());
	}

	public UnauthorizedException(String logMessage) {
		super(HttpStatus.UNAUTHORIZED, Errors.UNAUTHORIZED.getMessage(), Errors.UNAUTHORIZED.getCode(), logMessage, Collections.emptyMap());
	}

	public UnauthorizedException(String logMessage, Map<String, Object> additionalInfos) {
		super(HttpStatus.UNAUTHORIZED, Errors.UNAUTHORIZED.getMessage(), Errors.UNAUTHORIZED.getCode(), logMessage, additionalInfos);
	}
}
