package com.landvibe.ttotto.exception;

import lombok.Getter;

@Getter
public enum Errors {
	BAD_REQUEST("문제가 발생했습니다. 잠시 후 시도해주세요.", 0),
	INTERNAL_SERVER_ERROR("문제가 발생했습니다. 잠시 후 시도해주세요.", 1),
	NOT_FOUND("정보를 찾을 수 없습니다.", 2),
	UNAUTHORIZED("로그인 정보가 유효하지 않습니다.", 3);

	private final String message;
	private final Integer code;

	Errors(String message, Integer code) {
		this.message = message;
		this.code = code;
	}
}
