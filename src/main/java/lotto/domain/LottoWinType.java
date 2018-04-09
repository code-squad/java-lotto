package lotto.domain;

import java.util.Arrays;

public enum LottoWinType {
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
	
	public int getMatchCount() {
		return matchCount;
	}
	
	public int getPrize() {
		return prize;
	}
	
	public boolean hasMatchCount(int matchCount) {
		return matchCount == matchCount;
	}
	
	public int getPrize(int lottoNum) {
		return lottoNum * prize;
	}
	
	public static int[] getMatchCountValues() {
		return Arrays.stream(LottoWinType.values())
				.mapToInt(LottoWinType::getMatchCount)
				.toArray();
	}
	
	public static int getPrizeByMatchCount(int matchCount) {
		return Arrays.stream(LottoWinType.values())
				.filter(lottoWinType -> lottoWinType.hasMatchCount(matchCount))
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException("입력한 로또 번호 매칭카운트가 잘못되었습니다."))
				.getPrize();
	}
}
