package com.landvibe.ttotto.exception;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.Map;

public class InternalServerErrorException extends TtoTtoException {

	public InternalServerErrorException(String message, Integer code, String logMessage, Map<String, Object> additionalInfos) {
		super(HttpStatus.INTERNAL_SERVER_ERROR, message, code, logMessage, additionalInfos);
	}

	public InternalServerErrorException(String message, Integer code, String logMessage) {
		super(HttpStatus.INTERNAL_SERVER_ERROR, message, code, logMessage, Collections.emptyMap());
	}

	public InternalServerErrorException(String logMessage) {
		super(HttpStatus.INTERNAL_SERVER_ERROR, Errors.INTERNAL_SERVER_ERROR.getMessage(), Errors.INTERNAL_SERVER_ERROR.getCode(), logMessage, Collections.emptyMap());
	}

	public InternalServerErrorException(String logMessage, Map<String, Object> additionalInfos) {
		super(HttpStatus.INTERNAL_SERVER_ERROR, Errors.INTERNAL_SERVER_ERROR.getMessage(), Errors.INTERNAL_SERVER_ERROR.getCode(), logMessage, additionalInfos);
	}
}
