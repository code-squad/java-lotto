package domain;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ResultTest {
    private static final int PAYMENT = 10000;
    Result result = null;
    Map<Rank, Integer> ranking;

    @Before
    public void setup() throws Exception {
        ranking = new HashMap<>();
        for (Rank rank : Rank.values()) {
            ranking.put(rank, 1);
        }
        result = new Result(ranking, PAYMENT);
    }

    @Test
    public void insertResult() throws Exception {
        LottoDAO lottoDAO = new LottoDAO();
        lottoDAO.insertResult(ranking, result.calcRateOfProfit(PAYMENT));
    }

    @Test
    public void calcRateOfProfit() {
        // 1~5등까지 모두 1번씩 맞춤
        assertEquals(20315550 , result.calcRateOfProfit(PAYMENT));
    }

    @Test
    public void first() {
        assertEquals(1, result.getFirst());
    }

    @Test
    public void second() {
        assertEquals(1, result.getSecond());
    }

    @Test
    public void third() {
        assertEquals(1, result.getThird());
    }

    @Test
    public void fourth() {
        assertEquals(1, result.getFourth());
    }

    @Test
    public void fifth() {
        assertEquals(1, result.getFifth());
    }

    @Test
    public void rateOfProfit() {
        // 1~5등까지 모두 1번씩 맞춤
        assertEquals(20315550 , result.getRate());
    }
}
