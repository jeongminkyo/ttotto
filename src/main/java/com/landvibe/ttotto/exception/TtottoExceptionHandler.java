package com.landvibe.ttotto.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static net.logstash.logback.argument.StructuredArguments.entries;

@ControllerAdvice
@Slf4j
public class TtottoExceptionHandler {

	@ExceptionHandler(TtoTtoException.class)
	public ResponseEntity<ErrorResponse> handleTtoTtoException(TtoTtoException ex) {
		log.error(
			ex.getLogMessage(),
			entries(
				Map.of(
					"additional_infos", ex.getAdditionalInfos(),
					"stack_trace", getStackTraceSubList(ex)
				)
			)
		);

		ErrorResponse errorResponse = new ErrorResponse(ex.getCode(), ex.getMessage());
		return ResponseEntity.status(ex.getHttpStatus()).body(errorResponse);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		String errorMessage = ex.getBindingResult()
			.getFieldErrors()
			.stream()
			.map(DefaultMessageSourceResolvable::getDefaultMessage)
			.collect(Collectors.joining(", "));

		log.error(
			errorMessage,
			entries(
				Map.of("stack_trace", getStackTraceSubList(ex))
			)
		);

		ErrorResponse errorResponse = new ErrorResponse(Errors.BAD_REQUEST.getCode(), Errors.BAD_REQUEST.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}

	@ExceptionHandler(MissingRequestHeaderException.class)
	public ResponseEntity<ErrorResponse> handleMissingRequestHeaderException(MissingRequestHeaderException ex) {
		log.error(
			ex.getMessage(),
			entries(
				Map.of("stack_trace", getStackTraceSubList(ex))
			)
		);

		ErrorResponse errorResponse = new ErrorResponse(Errors.BAD_REQUEST.getCode(), Errors.BAD_REQUEST.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception ex) {
		log.error(
			ex.getMessage(),
			entries(
				Map.of("stack_trace", getStackTraceSubList(ex))
			)
		);

		ErrorResponse errorResponse = new ErrorResponse(Errors.INTERNAL_SERVER_ERROR.getCode(), Errors.INTERNAL_SERVER_ERROR.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	}

	private String getStackTraceSubList(Exception ex) {
		return Arrays.stream(ex.getStackTrace())
			.limit(5)
			.map(StackTraceElement::toString)
			.collect(Collectors.joining(" "));
	}
}
