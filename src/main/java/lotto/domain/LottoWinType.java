package lotto.domain;

import java.util.Arrays;

public enum LottoWinType {
	THREE_MATCH(3, 5000),
	FOUR_MATCH(4, 50000),
	FIVE_MATCH(5, 1500000),
	SIX_MATCH(6, 2000000000),
	ETC(0, 0);

	private int matchCount;
	private int prize;

	LottoWinType(int matchCount, int prize) {
		this.matchCount = matchCount;
		this.prize = prize;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getPrize() {
		return prize;
	}

	public boolean isMatchCount(int matchCount) {
		return this.matchCount == matchCount;
	}

	public static LottoWinType valueOf(int matchCount) {
		return Arrays.stream(LottoWinType.values())
				.filter(lottoWinType -> lottoWinType.isMatchCount(matchCount))
				.findAny()
				.orElse(ETC);
	}
}
