package lotto;

import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Joeylee on 2018-01-16.
 */
public class Result {
    private Map<Rank, Integer> lottoResult;


    public Result() {
        lottoResult = new HashMap<>();
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
           lottoResult.put(rank, 0);
        }
    }

    public Map<Rank, Integer> getLottoResult() {
        return lottoResult;
    }

    public void addLottoResult(Rank rank) {
        if(rank == null) {
            return;
        }
        lottoResult.put(rank, lottoResult.get(rank) + 1);
    }


    public int getSum() {
        int sum =0;
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            sum+= rank.getProfit(lottoResult.get(rank));
        }
        return sum;
    }

    public int rateTotal(int money) {
        return (getSum() - money) / money *100;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Rank rank : Rank.values())
            sb.append(rank.getState(lottoResult.get(rank)));
        return sb.toString();
    }
}
