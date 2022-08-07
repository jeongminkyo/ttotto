package com.landvibe.ttotto.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Event {
	FOOTBALL("축구"), BASEBALL("야구");

	private final String name;
}
