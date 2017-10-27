package lotto.service;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinLotto;
import lotto.model.WinPrice;
import lotto.model.WinPrice.WinValue;

public class LottoChecker {
	private WinLotto winLotto;
	private Lottos lottos;
	private WinPrice winPrice;

	public LottoChecker(Lottos lottos, WinLotto winLotto) {
		this.lottos = lottos;
		this.winLotto = winLotto;
		lottoCheck();
	}

	public void lottoCheck() {
		WinPrice winPrice = new WinPrice();
		for (int i = 0; i < lottos.size(); i++) {
			Lotto currnetLotto = lottos.getLotto(i);
			winPrice.addMatchCount(winLotto.compareLottoCount(currnetLotto), winLotto.compareBonusBall(currnetLotto));
		}
		this.winPrice = winPrice;
	}

	public int getTotalSumPrice() {
		return winPrice.getTotalSumPrice();
	}

	public WinValue matchCount(int index, boolean bonusCount) {
		return winPrice.valueOf(index, bonusCount);
	}

	public void checkLottosWinner() {
		lottoCheck();
		for (WinValue winValue : winPrice.keySet()) {
			System.out.println(winValue.getMatchNum() + "개 일치 " + winValue.getRankString() + " (" + winValue.getPrice()
					+ "원) - " + winPrice.getMatchCount(winValue) + "개");
		}
	}

	public float incomeRatio() {
		float totalPrice = winPrice.getTotalSumPrice();
		float ratio = (totalPrice / lottos.getPrice()) * 100;
		return ratio;
	}
}