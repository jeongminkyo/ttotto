package com.landvibe.ttotto.user.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.landvibe.ttotto.common.enums.Bat;
import com.landvibe.ttotto.common.enums.BatType;
import com.landvibe.ttotto.common.enums.Event;
import com.landvibe.ttotto.user.dto.MatchDetailResponse;
import com.landvibe.ttotto.user.response.MyBatMatchResponse;
import com.landvibe.ttotto.user.response.MyInfoResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/user")
public class UserController {

	@GetMapping(value = "/me")
	public MyInfoResponse myInfo() {
		return MyInfoResponse.builder()
			.email("redwonder@naver.com")
			.name("정민교")
			.point(1200L)
			.build();
	}

	@GetMapping(value = "/matches")
	public MyBatMatchResponse matches() {
		return MyBatMatchResponse.builder()
			.matches(List.of(MatchDetailResponse.builder()
					.id(1L)
					.name("월드컵 16강 A조")
					.date(LocalDate.of(2022, 10, 21))
					.competition("월드컵")
					.event(Event.FOOTBALL)
					.homeTeam("대한민국")
					.awayTeam("이탈리아")
					.batType(BatType.WIN_LOSE)
					.myBat(Bat.AWAY_WIN.name())
					.build(),
				MatchDetailResponse.builder()
					.id(2L)
					.name("월드컵 16강 B조")
					.date(LocalDate.of(2022, 10, 22))
					.competition("월드컵")
					.event(Event.FOOTBALL)
					.homeTeam("스페인")
					.awayTeam("독일")
					.batType(BatType.WIN_LOSE)
					.myBat(Bat.HOME_WIN.name())
					.build(),
				MatchDetailResponse.builder()
					.id(3L)
					.name("월드컵 16강 C조")
					.date(LocalDate.of(2022, 10, 23))
					.competition("월드컵")
					.event(Event.FOOTBALL)
					.homeTeam("잉글랜드")
					.awayTeam("프랑스")
					.batType(BatType.WIN_LOSE)
					.myBat(Bat.AWAY_WIN.name())
					.build()))
			.build();
	}
}
