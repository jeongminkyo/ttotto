package com.landvibe.ttotto.match.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.landvibe.ttotto.common.enums.Bat;
import com.landvibe.ttotto.common.enums.BatType;
import com.landvibe.ttotto.common.enums.Event;
import com.landvibe.ttotto.match.dto.MatchListDto;
import com.landvibe.ttotto.match.dto.WinRateDto;
import com.landvibe.ttotto.match.request.BatRequest;
import com.landvibe.ttotto.match.response.MatchDetailResponse;
import com.landvibe.ttotto.match.response.MatchListResponse;

@RestController
@RequestMapping(value = "/api/v1/matches")
public class MatchController {

	@GetMapping(value = "")
	public MatchListResponse matches() {
		return MatchListResponse.builder()
			.matches(List.of(MatchListDto.builder()
					.id(1L)
					.name("월드컵 16강 A조")
					.date(LocalDate.of(2022, 10, 23))
					.competition("월드컵")
					.event(Event.FOOTBALL)
					.homeTeam("대한민국")
					.awayTeam("이탈리아")
					.build(),
				MatchListDto.builder()
					.id(2L)
					.name("월드컵 16강 B조")
					.date(LocalDate.of(2022, 10, 21))
					.competition("월드컵")
					.homeTeam("스페인")
					.awayTeam("독일")
					.event(Event.FOOTBALL)
					.build()))
			.build();
	}

	@GetMapping(value = "/{id}")
	public MatchDetailResponse matches(@PathVariable Long id) {
		return MatchDetailResponse.builder()
			.id(id)
			.name("월드컵 16강 A조")
			.date(LocalDate.of(2022, 10, 23))
			.competition("월드컵")
			.event(Event.FOOTBALL)
			.homeTeam("대한민국")
			.awayTeam("이탈리아")
			.batType(BatType.WIN_DRAW_LOSE)
			.winRates(List.of(WinRateDto.builder()
					.type(Bat.HOME_WIN.name())
					.winRate(1.23)
					.build(),
				WinRateDto.builder()
					.type("DRAW")
					.winRate(1.43)
					.build(),
				WinRateDto.builder()
					.type(Bat.AWAY_WIN.name())
					.winRate(1.2)
					.build()
			))
			.build();
	}

	@PostMapping(value = "/{id}/bat")
	public Void matches(@PathVariable String id,
		@RequestBody BatRequest request) {
		return null;
	}
}
