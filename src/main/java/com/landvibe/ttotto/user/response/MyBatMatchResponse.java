package com.landvibe.ttotto.user.response;

import java.util.List;

import com.landvibe.ttotto.user.dto.MatchDetailResponse;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MyBatMatchResponse {
	List<MatchDetailResponse> matches;
}
