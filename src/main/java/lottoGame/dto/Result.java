package lottoGame.dto;

import lottoGame.domain.Lotto;
import lottoGame.util.LottoGenerator;

import java.util.HashMap;
import java.util.Iterator;
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

    public Result(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int price = lotto.profit();
            if(profit.containsKey(price)) {
                profit.put(price,profit.get(price) + 1);
            }
        }
    }

    public static int getAllProfit() {
        int result = 0;
        Iterator iterator = profit.keySet().iterator();

        while(iterator.hasNext()) {
            Integer key = (Integer) iterator.next();
            result += (key * profit.get(key));
        }
        //return (result / (lottos.size() * LottoGenerator.LOTTO_PRICE) * 100);
        return result;
    }
}
