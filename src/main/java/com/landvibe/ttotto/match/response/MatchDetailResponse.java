package com.landvibe.ttotto.match.response;

import java.time.LocalDate;
import java.util.List;

import com.landvibe.ttotto.common.enums.BatType;
import com.landvibe.ttotto.common.enums.Event;
import com.landvibe.ttotto.match.dto.WinRateDto;

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
	private List<WinRateDto> winRates;
}
