package domain;

import org.junit.Test;
import vo.Prize;

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
        for (Prize value : Prize.values()) {
            winnerInfo.put(value,0);
        }
        System.out.println(winnerInfo.keySet());
        assertThat(winnerInfo.size()).isEqualTo(4);
    }
}
