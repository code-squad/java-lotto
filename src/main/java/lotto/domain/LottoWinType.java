package lotto.domain;

import java.util.Arrays;

public enum LottoWinType {
	FIRST(6, 2000000000, false),
	SECOND(5, 30000000, true),
	THIRD(5, 1500000, false),
	FOURTH(4, 50000, false),
	FIFTH(3, 5000, false),
	MISS(0, 0, false);

	private int matchCount;
	private int prize;
	private boolean bonusFlag;

	LottoWinType(int matchCount, int prize, boolean bonusFlag) {
		this.matchCount = matchCount;
		this.prize = prize;
		this.bonusFlag = bonusFlag;
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

	public boolean isBonusFlag(boolean bonusFlag) {
		return this.bonusFlag == bonusFlag;
	}

	public static LottoWinType valueOf(int matchCount, boolean bonusFlag) {
		return Arrays.stream(LottoWinType.values())
				.filter(lottoWinType -> lottoWinType.isMatchCount(matchCount) && lottoWinType.isBonusFlag(bonusFlag))
				.findFirst()
				.orElse(MISS);
	}

	public static LottoWinType valueOf(int matchCount) {
		return valueOf(matchCount, false);
	}
}
