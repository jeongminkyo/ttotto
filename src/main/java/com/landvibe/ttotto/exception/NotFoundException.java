package com.landvibe.ttotto.exception;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.Map;

public class NotFoundException extends TtoTtoException {

	public NotFoundException(String message, Integer code, String logMessage, Map<String, Object> additionalInfos) {
		super(HttpStatus.NOT_FOUND, message, code, logMessage, additionalInfos);
	}

	public NotFoundException(String message, Integer code, String logMessage) {
		super(HttpStatus.NOT_FOUND, message, code, logMessage, Collections.emptyMap());
	}

	public NotFoundException(String logMessage) {
		super(HttpStatus.NOT_FOUND, Errors.NOT_FOUND.getMessage(), Errors.NOT_FOUND.getCode(), logMessage, Collections.emptyMap());
	}

	public NotFoundException(String logMessage, Map<String, Object> additionalInfos) {
		super(HttpStatus.NOT_FOUND, Errors.NOT_FOUND.getMessage(), Errors.NOT_FOUND.getCode(), logMessage, additionalInfos);
	}
}
