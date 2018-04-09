package lotto.domain;

import java.util.List;

public class LottoGame {
	private LottoGenerator lottoGenerator;
	private List<Lotto> lottos;
	
	public LottoGame(LottoGenerator lottoGenerator) {
		this.lottoGenerator = lottoGenerator;
	}
	
	public int play(int money, Numbers winNumbers) {
		return calculateProfitRate(winNumbers, money);
	}
	
	public List<Lotto> generateLottos(int money) {
		lottos = lottoGenerator.generate(getLottoNumer(money));
		return lottos;
	}
	
	private int sumPrize(List<Lotto> lottos, Numbers winNumbers) {
		return lottos.stream()
				.mapToInt(lotto -> LottoWinType.getPrizeByMatchCount(lotto.countMatchNumbers(winNumbers)))
				.sum();
	}
	
	public int calculateProfitRate(Numbers winNumbers, int money) {
		return sumPrize(lottos, winNumbers) / money * 100;
	}
	
	private int getLottoNumer(int money) {
		return money / Lotto.LOTTO_PRICE;
	}
}
