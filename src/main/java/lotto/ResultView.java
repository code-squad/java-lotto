package lotto;

import java.util.HashMap;

public class ResultView {
	private static final int CORRECT_THREE = 3;
	private static final int CORRECT_FOUR = 4;
	private static final int CORRECT_FIVE = 5;
	private static final int CORRECT_SIX = 6;

	public static void printStatus(HashMap<Integer, Integer> result) {
		System.out.println("3개 일치 (5000원)- " + result.get(CORRECT_THREE));
		System.out.println("4개 일치 (50000원)- " + result.get(CORRECT_FOUR));
		System.out.println("5개 일치 (1500000원)- " + result.get(CORRECT_FIVE));
		System.out.println("6개 일치 (2000000000원)- " + result.get(CORRECT_SIX));
	}

	public static void printLotto(Lottos lottos) {
		System.out.println(lottos.getBuyNum() + "개를 구매했습니다.");
		for (int i = 0; i < lottos.getBuyNum(); i++) {
			System.out.println(lottos.getLottos(i).toString());
		}
		System.out.println();
	}
}
