package lotto;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Joeylee on 2018-01-16.
 */
public class Result {

    public static Map<Integer, Integer> matchingPrice = new HashMap<>();
    public static Map<Integer, Integer> lottoResult = new HashMap<>();


    static {
        matchingPrice.put(3,5000);
        matchingPrice.put(4,50000);
        matchingPrice.put(5,1500000);
        matchingPrice.put(6,2000000000);

        lottoResult.put(3,0);
        lottoResult.put(4,0);
        lottoResult.put(5,0);
        lottoResult.put(6,0);
    }

    public void increaseCount(int matchCount) {
        if(matchCount >= 3) {
            lottoResult.put(matchCount, lottoResult.get(matchCount)+1);
        }
    }

    public static int getSum() {
        int sum =0;
        for (Integer integer : matchingPrice.keySet()) {
            sum += matchingPrice.get(integer) * lottoResult.get(integer);
        }
        return sum;
    }

    public static int rateTotal(int money) {
        return (getSum() - money) / money *100;
    }
}
