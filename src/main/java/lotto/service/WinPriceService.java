package lotto.service;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinPrice;

public class WinPriceService {
	private Lotto winnerLotto = null;
	private WinPrice winPrice = new WinPrice();

	public WinPriceService() {
		winnerNumbersInput();
		setWinPrice();
	}

	private void setWinPrice() {
		winPrice.addWinPrice(3, 5000);
		winPrice.addWinPrice(4, 50000);
		winPrice.addWinPrice(5, 1500000);
		winPrice.addWinPrice(6, 2000000000);
	}

	private void winnerNumbersInput() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		// scanner에서 No line found 라고 뜸 그래서 일단 자동생성
		winnerLotto = new Lotto();
		System.out.println(winnerLotto.getString());
	}

	public void lottoCheck(Lottos lottos) {
		for (int i = 0; i < lottos.size(); i++) {
			winPrice.addMatchCount(winnerLotto.compareLottoCount(lottos.getLotto(i)));
		}
	}

	public void checkLottosWinner(Lottos lottos) {
		lottoCheck(lottos);
		for (int key : winPrice.keySet()) {
			int value[] = winPrice.get(key);
			System.out.println(key + "개 일치 (" + value[0] + "원) - " + value[1] + "개");
		}
	}

	public int getTotalSumPrice() {
		return winPrice.getTotalSumPrice();
	}

	public float incomeRatio(Lottos lottos) {
		float totalPrice = winPrice.getTotalSumPrice();
		float ratio = (totalPrice / lottos.getPrice()) * 100;
		return ratio;
	}
}
