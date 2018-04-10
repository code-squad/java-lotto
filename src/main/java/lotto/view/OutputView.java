package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoWinType;
import lotto.domain.Numbers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toMap;

public class OutputView {
	private static final String NUMBERS_VIEW_DELIMITER = ", ";
	
	public static void showLottosView(List<Lotto> lottos) {
		System.out.println(lottos.size() + "개를 구매했습니다.");
		lottos.stream()
				.forEach(lotto -> showLottoView(lotto));
	}
	
	public static void showLottoView(Lotto lotto) {
		System.out.print("[");
		showNumbersView(lotto.getNumbers());
		System.out.println("]");
	}
	
	public static void showNumbersView(Numbers numbers) {
		System.out.print(numbers.stream()
				.map(number -> Integer.toString(number))
				.collect(joining(NUMBERS_VIEW_DELIMITER)));
	}

	public static void showResultView(TreeMap<LottoWinType, ? extends Number> results) {
		System.out.println("당첨 통계\n---------");

		results.forEach((lottoWinType, count) -> System.out.println(new StringBuilder().append(lottoWinType.getMatchCount())
				.append("개 일치 (")
				.append(lottoWinType.getPrize())
				.append("원) - ")
				.append(count)
				.append("개")));
	}

	public static void showProfitRateView(int profitRate) {
		System.out.println("총 수익률은 " + profitRate + "%입니다.");
	}
}
