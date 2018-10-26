package domain;

import dto.WinStatsDto;
import org.junit.Test;
import vo.Rank;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class WinStatsTest {
    private static WinStats wc;
    static{
        List<String> list = new ArrayList<>();
        LottoBundle randomLottoBundle = LottoFactory.generateLottoBundle(0,list);
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Set<Integer> set1 = new HashSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 9, 10, 11));

        WinningLotto theWinningLotto = LottoFactory.generateWinningLotto(set, 7);

        randomLottoBundle.add(LottoFactory.generateTheLotto(set1));
        randomLottoBundle.add(LottoFactory.generateTheLotto(set1));
        randomLottoBundle.add(LottoFactory.generateTheLotto(set1));
        randomLottoBundle.add(LottoFactory.generateTheLotto(set1));
        randomLottoBundle.add(LottoFactory.generateTheLotto(set2));

        wc = randomLottoBundle.calculateWinStats(theWinningLotto);
    }

    @Test
    public void WinStats() {
        assertThat(wc.toDto().getEarningRate()).isEqualTo(100.0);
    }

    @Test
    public void WinStatsDtoTest(){
        WinStatsDto wd = wc.toDto();
        for (Rank rank : Rank.values()){
            if(rank.equals(Rank.FIFTH)) assertThat(wd.getNumberOfCounts(rank)).isEqualTo(1);
            else assertThat(wd.getNumberOfCounts(rank)).isEqualTo(0);
        }
    }
}
