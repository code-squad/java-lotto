package lotto.domain;

import lotto.type.WinningType;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void create(){
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,60));
    }

    @Test
    public void getMatchCount(){
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        Lotto matchLottoFive = new Lotto(Arrays.asList(1,2,3,4,5,7));
        assertThat(lotto.getMatchCount(matchLottoFive)).isEqualTo(5);

        Lotto matchLottoNone = new Lotto(Arrays.asList(7,8,9,10,11,12));
        assertThat(lotto.getMatchCount(matchLottoNone)).isEqualTo(0);
    }

    @Test
    public void matchLuckyNumbers() {

        Lotto winningLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        Lotto lottoNotMatch = new Lotto(Arrays.asList(8,9,10,11,12,13));
        assertThat(lottoNotMatch.matchLuckyNumbers(winningLotto)).isEqualTo(WinningType.NONE);

        Lotto lottoMatchAll = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertThat(lottoMatchAll.matchLuckyNumbers(winningLotto)).isEqualTo(WinningType.MATCH_ALL);

    }

    @Test
    public void getWinningPrizes(){
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        Lotto matchLottoFive = new Lotto(Arrays.asList(1,2,3,4,5,7));
        lotto.matchLuckyNumbers(matchLottoFive);

        assertThat(lotto.getWinningPrizes()).isEqualTo(WinningType.MATCH_FIVE.getPrizes());

    }

    @Test
    public void isWInningType(){
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        Lotto matchLottoFour = new Lotto(Arrays.asList(1,2,3,4,8,7));
        lotto.matchLuckyNumbers(matchLottoFour);

        assertThat(lotto.isWinningType(WinningType.MATCH_FOUR)).isTrue();

    }

}