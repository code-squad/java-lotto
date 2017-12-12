package lotto;

import java.util.HashMap;

public class ResultView {

	public static void printStatus(HashMap<Match, Integer> result) {
		System.out.println("3개 일치 (5000원) - " +result.get(Match.MATCH_FOURTH));
		System.out.println("4개 일치 (50000원) - " + result.get(Match.MATCH_THIRD));
		System.out.println("5개 일치 (1500000원) - " +result.get(Match.MATCH_SECOND));
		System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " + (result.get(Match.MATCH_BONUS)));
		System.out.println("6개 일치 (2000000000원) - " + result.get(Match.MATCH_FIRST));
	}

	public static void printLotto(Lottos lottos) {
		System.out.println(lottos.getBuyNum() + "개를 구매했습니다.");
		for (int i = 0; i < lottos.getBuyNum(); i++)
			System.out.println(lottos.getLottos(i).toString());
		System.out.println();
	}
}
