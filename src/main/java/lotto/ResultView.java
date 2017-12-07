package lotto;

import java.util.ArrayList;

public class ResultView {
	public static void printStatus(ArrayList<Integer> result, int money) {
		System.out.println("3개 일치 (5000원)- " + result.get(3));
		System.out.println("4개 일치 (50000원)- " + result.get(4));
		System.out.println("5개 일치 (1500000원)- " + result.get(5));
		System.out.println("6개 일치 (2000000000원)- " + result.get(6));
		printBenefit(result, money);

	}

	private static void printBenefit(ArrayList<Integer> result, int money) {

		Double total = (double) ((5000 * result.get(3))
				+ (50000 * result.get(4) + (1500000 * result.get(5)) + (2000000000 * result.get(6))));
		System.out.println("수익률은 " + Math.floor(total / money * 10) * 10 + "% 입니다.");
	}

	public static void printLotto(Lottos lottos) {
		System.out.println(lottos.getBuyNum() + "개를 구매했습니다.");
		for (int i = 0; i < lottos.getBuyNum(); i++) {
			System.out.println(lottos.getLottos(i).getMyLotto());
		}
		System.out.println();
	}
}
