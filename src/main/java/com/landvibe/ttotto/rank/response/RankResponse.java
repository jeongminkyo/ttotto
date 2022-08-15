package com.landvibe.ttotto.rank.response;

import java.util.List;

import com.landvibe.ttotto.match.dto.MatchListDto;
import com.landvibe.ttotto.rank.dto.RankDto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RankResponse {
	private List<RankDto> rank;
}

