package domain;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StatisticTest {
    @Test
    public void checkLottoRank(){
        Map<Integer,Integer> resultInfo = new HashMap<>();
        resultInfo.put(0,0);
        resultInfo.put(0,resultInfo.get(0)+1);
        resultInfo.put(0,resultInfo.get(0)+1);
        resultInfo.put(0,resultInfo.get(0)+1);
        assertThat(resultInfo.get(0)).isEqualTo(3);
    }

    @Test
    public void initWinnerInfo(){
        Map<Prize,Integer> winnerInfo = new LinkedHashMap<>();
        winnerInfo.put(Prize.THREE, 0);
        winnerInfo.put(Prize.FOUR, 0);
        winnerInfo.put(Prize.FIVE, 0);
        winnerInfo.put(Prize.SIX, 0);
        System.out.println(winnerInfo.keySet());
    }
}
