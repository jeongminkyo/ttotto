package com.landvibe.ttotto.user.dto;

import java.time.LocalDate;

import com.landvibe.ttotto.common.enums.BatType;
import com.landvibe.ttotto.common.enums.Event;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MatchDetailResponse {
	private Long id;
	private String name;
	private LocalDate date;
	private String competition;
	private Event event;
	private String homeTeam;
	private String awayTeam;
	private BatType batType;
	private String myBat;
}
