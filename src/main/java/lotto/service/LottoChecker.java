package lotto.service;

import java.util.Set;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinLotto;
import lotto.model.WinPrice;
import lotto.model.WinPrice.WinValue;

public class LottoChecker {
	private WinLotto winLotto;
	private Lottos lottos;
	private WinPrice winPrice;
	
	public WinPrice getWinPrice() {
		return winPrice;
	}

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

	public double incomeRatio() {
		double totalPrice = winPrice.getTotalSumPrice();
		double ratio = (totalPrice / (lottos.size() * 1000)) * 100;
		return ratio;
	}
}