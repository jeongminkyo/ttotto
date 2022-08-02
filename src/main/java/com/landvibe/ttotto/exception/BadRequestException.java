package com.landvibe.ttotto.exception;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.Map;

public class BadRequestException extends TtoTtoException {

	public BadRequestException(String message, Integer code, String logMessage, Map<String, Object> additionalInfos) {
		super(HttpStatus.BAD_REQUEST, message, code, logMessage, additionalInfos);
	}

	public BadRequestException(String message, Integer code, String logMessage) {
		super(HttpStatus.BAD_REQUEST, message, code, logMessage, Collections.emptyMap());
	}

	public BadRequestException(String logMessage) {
		super(HttpStatus.BAD_REQUEST, Errors.BAD_REQUEST.getMessage(), Errors.BAD_REQUEST.getCode(), logMessage, Collections.emptyMap());
	}

	public BadRequestException(String logMessage, Map<String, Object> additionalInfos) {
		super(HttpStatus.BAD_REQUEST, Errors.BAD_REQUEST.getMessage(), Errors.BAD_REQUEST.getCode(), logMessage, additionalInfos);
	}
}
