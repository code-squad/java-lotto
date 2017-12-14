package lotto;

import java.util.HashMap;
import static lotto.Rank.RANK_FIRST;
import static lotto.Rank.RANK_SECOND;
import static lotto.Rank.RANK_THIRD;
import static lotto.Rank.RANK_FOURTH;
import static lotto.Rank.RANK_BONUS;

public class ResultView {

	public static void printStatus(HashMap<Rank, Integer> result) {
		System.out.println("3개 일치 (5000원) - " +result.get(RANK_FOURTH));
		System.out.println("4개 일치 (50000원) - " + result.get(RANK_THIRD));
		System.out.println("5개 일치 (1500000원) - " +result.get(RANK_SECOND));
		System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " + (result.get(RANK_BONUS)));
		System.out.println("6개 일치 (2000000000원) - " + result.get(RANK_FIRST));
	}

	public static void printLotto(Lottos lottos) {
		System.out.println("수동으로 " + lottos.getUserNum() + "개, 자동으로 " + (lottos.getBuyNum() - lottos.getUserNum()) + "개를 구매했습니다.");
		for (int i = 0; i < lottos.getBuyNum(); i++)
			System.out.println(lottos.getLottos(i).toString());
		System.out.println();
	}
}
