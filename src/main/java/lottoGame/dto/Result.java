package lottoGame.dto;

import lottoGame.domain.Lotto;
import lottoGame.util.LottoGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    public static Map<Integer,Integer> profit = new HashMap<>();

    static {
        profit.put(5000,0);
        profit.put(50000,0);
        profit.put(1500000,0);
        profit.put(2000000000,0);
    }

    public void winnerResult(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int price = lotto.profit();
            if(profit.containsKey(price)) {
                profit.put(price,profit.get(price) + 1);
            }
        }
    }

    public static int calcPrice(List<Lotto> lottos) {
        int result = 0;
        for (Lotto lotto : lottos) {
            result += lotto.profit();
        }

        return (result/(lottos.size() * LottoGenerator.LOTTO_PRICE) * 100);
    }
}
