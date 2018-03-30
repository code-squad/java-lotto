package lotto.lotto.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LottoTest {

    @Test
    public void coutOfMatchLottoTest() {
        Lotto test = Lotto.of("35, 23, 2, 42, 21, 13");
        WeeklyLotto test2 = WeeklyLotto.of("35, 23, 2, 42, 21, 13", 5);
        assertThat(test.valueOfRank(test2), is(Rank.FIRST));

        WeeklyLotto test3 = WeeklyLotto.of("2, 41, 5, 42, 21, 13", 6);
        assertThat(test.valueOfRank(test3), is(Rank.FOURTH));
    }

    @Test
    public void collectNumberTest() {
        Lotto test = Lotto.of("35, 23, 2, 42, 21, 13");
        assertThat(test.collectNumber(2, 0), is(1));//당첨번호와 일치할때

        assertThat(test.collectNumber(5, 1), is(1));//당첨번호와 일치하지 않을때
    }

    @Test
    public void rankTest() {
        assertThat(Rank.valueOf(4, false), is(Rank.FOURTH));
    }

    @Test
    public void checkRankTest() { //로또 당첨 확인을 하고 당첨된 등수를 반환
        WeeklyLotto test = WeeklyLotto.of("1, 2, 3, 4, 5, 6", 7);
        Lotto test2 = new Lotto(Arrays.asList(35, 23, 2, 42, 21, 13));
        Lotto test3 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Lotto> testList = new ArrayList<>();

        testList.add(test2);
        testList.add(test3);

        assertThat(test.checkRank(testList).get(Rank.FIRST), is(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void notLottoExceptionTest() {
        WeeklyLotto test = WeeklyLotto.of("5, 1, 2, 3, 4, 5, 46", 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void overExceptionTest() {
        WeeklyLotto test = WeeklyLotto.of("1, 2, 3, 4, 5, 46", 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void underExceptionTest() {
        WeeklyLotto test = WeeklyLotto.of("0, 2, 3, 4, 5, 6", 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sameNumberExceptionTest() {
        WeeklyLotto test = WeeklyLotto.of("1, 2, 3, 5, 5, 6", 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkSameBonusExceptionTest() {
        WeeklyLotto test = WeeklyLotto.of("1, 2, 3, 5, 5, 6", 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkBonusExceptionTest() {
        WeeklyLotto test = WeeklyLotto.of("1, 2, 3, 5, 5, 6", 50);
    }

    @Test(expected = IllegalArgumentException.class)
    public void moneyCheckExceptionTest() {  //돈이 1000원 미만 일때
        BuyingLotto test = new BuyingLotto(500);
    }

    @Test(expected = IllegalArgumentException.class)
    public void moneyCheckExceptionTest2() {  //돈이 1000원 단위가 아닐때
        BuyingLotto test = new BuyingLotto(1300);
    }
}