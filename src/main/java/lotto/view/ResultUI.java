package lotto.view;

import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoStore;
import lotto.domain.PriceType;

public class ResultUI {

    public static void printCount(LottoStore lottoStore) {
        System.out.println(lottoStore.getLottos().size() + "개를 구매했습니다.");

    }

    public static void printLottos(LottoStore lottoStore) {
        for (Lotto lotto : lottoStore.getLottos()) {
            printLotto(lotto);
        }
    }

    private static void printLotto(Lotto lotto) {
        System.out.println("[" + lotto.joinNumbers() + "]");
    }

    public static void printStatistics(LottoStore lottoStore) {
        Map<PriceType, Integer> result = lottoStore.getStatistics();
        for (PriceType priceType : result.keySet()) {
            System.out.println(priceType.getCount() + "개 일치 (" + priceType.getPrice() + ") - " + result.get(priceType) + "개");

        }
    }

    public static void printPercentage(LottoResult lottoResult) {
        System.out.println("수익률은 "+lottoResult.getPercentage()+"% 입니다");
    }
}
