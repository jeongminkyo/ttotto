package com.landvibe.ttotto.user.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MyInfoResponse {

	private String name;
	private String email;
	private Long point;
}
