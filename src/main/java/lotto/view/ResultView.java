package lotto.view;

import lotto.model.Lottos;
import lotto.model.WinLotto;
import lotto.model.WinPrice;
import lotto.model.WinPrice.WinValue;
import lotto.service.LottoChecker;

public class ResultView {
	private WinLotto winnerLotto = null;
	private LottoChecker lottoChecker = null;

	public ResultView(Lottos lottos) {
		winnerNumbersInput();
		lottoChecker = new LottoChecker(lottos, winnerLotto);
	}
	
	public ResultView(Lottos lottos, WinLotto winLotto) {
		lottoChecker = new LottoChecker(lottos, winLotto);
	}

	private void winnerNumbersInput() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		// scanner에서 No line found 라고 뜸 그래서 일단 자동생성
		winnerLotto = new WinLotto();
		System.out.println(winnerLotto.getString());
		System.out.println();
	}

	public void resultPrint() {
		System.out.println("당첨 통계");
		System.out.println("---------");
		WinPrice winPrice = lottoChecker.getWinPrice();
		for (WinValue winValue : winPrice.keySet()) {
			System.out.println(winValue.getMatchNum() + "개 일치 " + winValue.getRankString() + " (" + winValue.getPrice()
					+ "원) - " + winPrice.getMatchCount(winValue) + "개");
		}
		System.out.println("총 수입금은 " + lottoChecker.getTotalSumPrice() + "원 입니다.");
		System.out.println("총 수익률은 " + lottoChecker.incomeRatio() + "%입니다.");
	}
}