package com.landvibe.ttotto.common.enums;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BatType {
	WIN_DRAW_LOSE("승무패", Arrays.asList(Bat.HOME_WIN, Bat.DRAW, Bat.AWAY_WIN)),
	WIN_LOSE("승패", Arrays.asList(Bat.HOME_WIN, Bat.AWAY_WIN));

	private final String description;
	private final List<Bat> bat;
}
