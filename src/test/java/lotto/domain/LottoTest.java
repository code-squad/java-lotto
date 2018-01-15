package lotto.domain;

import lotto.type.WinningType;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {

    @Test
    public void create() {
        Lotto lotto = new Lotto();
        assertThat(lotto).isNotNull();

    }

    @Test
    public void matchLuckyNumbers() {
        int[] luckyNumbers = new int[]{1,2,3,4,5,6};

        Lotto lotto = new Lotto();
        WinningType type = lotto.matchLuckyNumbers(luckyNumbers);
        System.out.println("lotto: "+ lotto);
        System.out.println("winning type: "+type);

        int matchCount = lotto.getMatchCount(luckyNumbers);
        System.out.println("match count: "+matchCount);

        assertThat(lotto.isWinningType(WinningType.parse(matchCount))).isTrue();

    }
}