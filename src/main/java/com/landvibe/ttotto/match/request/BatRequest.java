package com.landvibe.ttotto.match.request;

import com.landvibe.ttotto.common.enums.Bat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BatRequest {

	private Long userId;
	private Bat bat;
}
