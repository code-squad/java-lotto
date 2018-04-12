package lotto.domain;

import java.util.Arrays;

public enum LottoWinType {
	FIRST(6, 2000000000),
	SECOND(5, 30000000),
	THIRD(5, 1500000),
	FOURTH(4, 50000),
	FIFTH(3, 5000),
	MISS(0, 0);

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
				.findFirst()
				.orElse(MISS);
	}
}
