package com.landvibe.ttotto.match.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
// 배당률 dto
public class WinRateDto {
	private String type;
	private Double winRate;
}
