package com.landvibe.ttotto.exception;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CustomErrorController implements ErrorController {

	@RequestMapping("/error")
	public ResponseEntity<ErrorResponse> handleError() {
		ErrorResponse errorResponse = new ErrorResponse(Errors.NOT_FOUND.getCode(), Errors.NOT_FOUND.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}
}
