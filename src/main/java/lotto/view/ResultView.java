package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinPrice;

enum WinValue {
	FIFTH(3, 5000), FOURTH(4, 50000), THRD(5, 1500000), FIRST(6, 2000000000);
	private final int value;
	private final int price;

	WinValue(int value, int price) {
		this.value = value;
		this.price = price;
	}

	public int getValue() {
		return value;
	}

	public int getPrice() {
		return price;
	}
}

public class ResultView {
	private Lotto winnerLotto = null;
	private WinPrice winPrice = new WinPrice();

	public ResultView() {
		winnerNumbersInput();
		setWinPrice();
	}

	private void setWinPrice() {
		winPrice.addWinPrice(WinValue.FIFTH.getValue(), WinValue.FIFTH.getPrice());
		winPrice.addWinPrice(WinValue.FOURTH.getValue(), WinValue.FOURTH.getPrice());
		winPrice.addWinPrice(WinValue.THRD.getValue(), WinValue.THRD.getPrice());
		winPrice.addWinPrice(WinValue.FIRST.getValue(), WinValue.FIRST.getPrice());
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
			System.out.println(key + "개 일치 (" + winPrice.getPrice(key) + "원) - " + winPrice.getMatchCount(key) + "개");
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
