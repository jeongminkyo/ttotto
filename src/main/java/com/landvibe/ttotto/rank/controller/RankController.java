package com.landvibe.ttotto.rank.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.landvibe.ttotto.rank.dto.RankDto;
import com.landvibe.ttotto.rank.response.RankResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/rank")
public class RankController {

	@GetMapping(value = "")
	public RankResponse rank() {
		return RankResponse.builder()
			.rank(List.of(RankDto.builder()
					.name("문우곤")
					.rank(1L)
					.point(1200L)
					.build(),
				RankDto.builder()
					.name("이준")
					.rank(2L)
					.point(1100L)
					.build(),
				RankDto.builder()
					.name("전준호")
					.rank(3L)
					.point(1000L)
					.build()))
			.build();

	}
}
