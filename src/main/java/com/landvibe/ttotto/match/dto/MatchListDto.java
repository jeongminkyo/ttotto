package com.landvibe.ttotto.match.dto;

import java.time.LocalDate;

import com.landvibe.ttotto.common.enums.Event;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MatchListDto {
	private Long id;
	private String name;
	private LocalDate date;
	private String competition;
	private Event event;
	private String homeTeam;
	private String awayTeam;
}
