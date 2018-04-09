package lotto.domain;

import java.util.List;

public class LottoGame {
	private LottoGenerator lottoGenerator;
	private List<Lotto> lottos;
	
	public LottoGame(LottoGenerator lottoGenerator) {
		this.lottoGenerator = lottoGenerator;
	}

	public List<Lotto> generateLottos(int money) {
		lottos = lottoGenerator.generate(getLottoNumer(money));
		return lottos;
	}

    public int calculateProfitRate(Numbers winNumbers, int money) {
        return sumPrize(winNumbers) / money * 100;
    }

    private int getLottoNumer(int money) {
        return money / Lotto.LOTTO_PRICE;
    }

	private int sumPrize(Numbers winNumbers) {
		return lottos.stream()
				.mapToInt(lotto -> LottoWinType.getPrizeByMatchCount(lotto.countMatchNumbers(winNumbers)))
				.sum();
	}
}
