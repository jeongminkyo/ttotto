package com.landvibe.ttotto.rank.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RankDto {
	private String name;
	private Long rank;
	private Long point;
}
