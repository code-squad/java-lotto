package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoWinType {
	ZERO_MATCH(0, 0),
	THREE_MATCH(3, 5000),
	FOUR_MATCH(4, 50000),
	FIVE_MATCH(5, 1500000),
	SIX_MATCH(6, 2000000000);
	
	private int matchCount;
	private int prize;
	
	LottoWinType(int matchCount, int prize) {
		this.matchCount = matchCount;
		this.prize = prize;
	}
	
	public int getPrize() {
		return prize;
	}
	
	public boolean isMatchCount(int matchCount) {
		return this.matchCount == matchCount;
	}
	
	public static int getPrizeByMatchCount(int matchCount) {
		return Arrays.stream(LottoWinType.values())
				.filter(lottoWinType -> lottoWinType.isMatchCount(matchCount))
				.findFirst()
				.orElse(ZERO_MATCH)
				.getPrize();
	}
}
