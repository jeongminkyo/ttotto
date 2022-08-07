package com.landvibe.ttotto.match.response;

import java.util.List;

import com.landvibe.ttotto.match.dto.MatchListDto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MatchListResponse {
	private List<MatchListDto> matches;
}

