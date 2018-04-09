package lotto.domain;

import java.util.List;

public class LottoGame {
	private LottoGenerator lottoGenerator;
	
	public LottoGame(LottoGenerator lottoGenerator) {
		this.lottoGenerator = lottoGenerator;
	}
	
	public int play(int money, Numbers winNumbers) {
		return calculateProfitRate(lottoGenerator.generate(getLottoNumer(money)), winNumbers, money);
	}
	
	private int sumPrize(List<Lotto> lottos, Numbers winNumbers) {
		return lottos.stream()
				.mapToInt(lotto -> LottoWinType.getPrizeByMatchCount(lotto.countMatchNumbers(winNumbers)))
				.sum();
	}
	
	private int calculateProfitRate(List<Lotto> lottos, Numbers winNumbers, int money) {
		return sumPrize(lottos, winNumbers) / money * 100;
	}
	
	private int getLottoNumer(int money) {
		return money / Lotto.LOTTO_PRICE;
	}
}
