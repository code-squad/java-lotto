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
        WeeklyLotto test2 = new WeeklyLotto("35, 23, 2, 42, 21, 13");
        assertThat(test.coutOfMatchLotto(test2), is(Rank.FIRST));

        WeeklyLotto test3 = new WeeklyLotto("2, 41, 5, 42, 21, 13");
        assertThat(test.coutOfMatchLotto(test3), is(Rank.FOURTH));
    }

    @Test
    public void collectNumberTest() {
        Lotto test = Lotto.of("35, 23, 2, 42, 21, 13");
        assertThat(test.collectNumber(2, 0), is(1));//당첨번호와 일치할때

        assertThat(test.collectNumber(5, 1), is(1));//당첨번호와 일치하지 않을때
    }

    @Test
    public void rankTest() {
        assertThat(Rank.valueOf(4), is(Rank.FOURTH));
    }

    @Test
    public void checkRankTest() { //로또 당첨 확인을 하고 당첨된 등수를 반환
        WeeklyLotto test = new WeeklyLotto("1, 2, 3, 4, 5, 6");
        Lotto test2 = new Lotto(Arrays.asList(35, 23, 2, 42, 21, 13));
        Lotto test3 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Lotto> testList = new ArrayList<>();

        testList.add(test2);
        testList.add(test3);

        assertThat(test.checkRank(testList), is(Arrays.asList(1, 0, 0, 0)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void notLottoExceptionTest() {
        WeeklyLotto test = new WeeklyLotto("5, 1, 2, 3, 4, 5, 46");
    }

    @Test(expected = IllegalArgumentException.class)
    public void overExceptionTest() {
        WeeklyLotto test = new WeeklyLotto("1, 2, 3, 4, 5, 46");
    }

    @Test(expected = IllegalArgumentException.class)
    public void underExceptionTest() {
        WeeklyLotto test = new WeeklyLotto("0, 2, 3, 4, 5, 6");
    }

    @Test(expected = IllegalArgumentException.class)
    public void sameNumberExceptionTest() {
        WeeklyLotto test = new WeeklyLotto("1, 2, 3, 5, 5, 6");
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