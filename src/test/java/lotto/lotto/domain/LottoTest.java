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
        Lotto test = new Lotto(Arrays.asList(35, 23, 2, 42, 21, 13));
        List<Integer> test2 = new ArrayList<Integer>(Arrays.asList(35, 23, 2, 42, 21, 13));
        assertThat(test.coutOfMatchLotto(test2), is(6));

        List<Integer> test3 = new ArrayList<Integer>(Arrays.asList(4, 15, 2, 42, 21, 13));
        assertThat(test.coutOfMatchLotto(test3), is(4));
    }

    @Test
    public void collectNumberTest() {
        Lotto test = new Lotto(Arrays.asList(35, 23, 2, 42, 21, 13));
        assertThat(test.collectNumber(2, 0), is(1));//당첨번호와 일치할때

        assertThat(test.collectNumber(5, 1), is(1));//당첨번호와 일치하지 않을때
    }

    @Test
    public void rankTest() {
        assertThat(Rank.valueOf(4), is(Rank.FOURTH));
    }

    @Test
    public void confirmRankTest() { //로또 당첨 확인을 하고 당첨된 등수를 반환
        WeeklyLotto test = new WeeklyLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto test2 = new Lotto(Arrays.asList(35, 23, 2, 42, 21, 13));
        Lotto test3 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Lotto> testList = new ArrayList<>();

        testList.add(test2);
        testList.add(test3);

        assertThat(test.confirmRank(testList), is(Arrays.asList(1, 0, 0, 0)));
    }

    @Test
    public void caseOfRank() {  //switch문에 들어가는 value에 따라 rank가 바뀌는지 확인
        WeeklyLotto test = new WeeklyLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> rank = new ArrayList<>(Arrays.asList(0, 0, 0, 0));

        Rank value = Rank.THIRD;
        test.caseOfRank(value, rank);
        assertThat(rank, is(Arrays.asList(0, 1, 0, 0)));
    }

}