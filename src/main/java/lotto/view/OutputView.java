package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Numbers;

import java.util.List;

import static java.util.stream.Collectors.joining;

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
		System.out.print(numbers.getNumbers().stream()
				.map(number -> Integer.toString(number))
				.collect(joining(NUMBERS_VIEW_DELIMITER)));
	}
	
	public static void showProfitRateView(int profitRate) {
		System.out.println("총 수익률은 " + profitRate + "%입니다.");
	}
}
