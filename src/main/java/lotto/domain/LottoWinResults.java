package lotto.domain;

import java.util.Map;

public class LottoWinResults {
	private Map<LottoWinType, Long> results;
	
	public LottoWinResults(Map<LottoWinType, Long> results) {
		this.results = results;
	}
	
	public int sumPrize() {
		return (int) results.keySet().stream()
				.mapToLong(lottoWinType -> lottoWinType.getPrize() * results.get(lottoWinType))
				.sum();
	}
}
