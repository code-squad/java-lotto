package domain;

import dto.WinStatsDto;
import org.junit.Test;
import vo.Money;
import vo.Rank;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class WinStatsTest {
    private static WinStats wc;
    static{
        List<String> list = Arrays.asList("5,6,7,8,9,10", "5,6,7,8,9,10", "5,6,7,8,9,10", "5,6,7,8,9,10", "1,2,3,9,10,11");

        LottoBundleFactory manual = new ManualLottoBundleFactory(list);
        LottoBundle randomLottoBundle = manual.generate(5);


        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        WinningLotto theWinningLotto = WinningLottoFactory.generateWinningLotto(set, 7);

        wc = randomLottoBundle.calculateWinStats(theWinningLotto, Money.of(5000));
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
