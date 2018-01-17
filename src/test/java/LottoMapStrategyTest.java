import model.Lotto;
import model.LottoMapStrategy;
import model.Rank;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMapStrategyTest {

    @Test
    public void sortMap(){
        Map<Rank, Integer> unsortedMap = new HashMap();
        unsortedMap.put(Rank.FIRST, 4);
        unsortedMap.put(Rank.FOURTH, 10);
        unsortedMap.put(Rank.THIRD, 1);

        Map<Rank, Integer> sortedMap = new LinkedHashMap();
        sortedMap.put(Rank.FIRST, 4);
        sortedMap.put(Rank.THIRD, 1);
        sortedMap.put(Rank.FOURTH, 10);

        assertThat(LottoMapStrategy.sortMap(unsortedMap)).isEqualTo(sortedMap);
    }

    @Test
    public void combinedByRank(){
        Map<Rank, Integer> result = new HashMap();
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }

        Map<Lotto, Rank> lottoMapStrategyRankMap = new HashMap();
        assertThat(LottoMapStrategy.combinedByRank(lottoMapStrategyRankMap)).isEqualTo(result);
    }
}
