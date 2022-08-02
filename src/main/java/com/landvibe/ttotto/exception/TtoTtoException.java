package com.landvibe.ttotto.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.Map;

@Getter
public class TtoTtoException extends RuntimeException {
	private final HttpStatus httpStatus;
	private final String logMessage;
	private final Integer code;
	private final Map<String, Object> additionalInfos;

	public TtoTtoException(HttpStatus httpStatus, String message, Integer code, String logMessage, Map<String, Object> additionalInfos) {
		super(message);
		this.httpStatus = httpStatus;
		this.logMessage = logMessage;
		this.code = code;
		this.additionalInfos = additionalInfos;
	}
}
