import domain.Numbers;
import enums.Menu;
import org.junit.Test;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
/**
 * Created by hoon on 2018. 1. 13..
 */
public class TicketTest {

    @Test
    public void 당첨_테스트() {
        ArrayList<Integer> test1 = new ArrayList<>();
        test1.add(1);
        test1.add(2);
        test1.add(3);
        test1.add(4);
        test1.add(5);
        test1.add(6);
        Numbers numbers1 = new Numbers(test1);

        ArrayList<Integer> test2 = new ArrayList<>();
        test2.add(10);
        test2.add(2);
        test2.add(3);
        test2.add(4);
        test2.add(5);
        test2.add(6);
        Numbers numbers2 = new Numbers(test2);

        List<Integer> test3 = new ArrayList<>();
        test3.add(1);
        test3.add(2);
        test3.add(3);
        test3.add(4);
        test3.add(5);
        test3.add(6);
        Numbers numbers3 = new Numbers(test3);

        assertThat(numbers1.calculateHits(numbers2), is(5));
        assertThat(numbers1.calculateHits(numbers3), is(6));

    }

    @Test
    public void 수익률_테스트() {
        ArrayList<Integer> test2 = new ArrayList<>();
        test2.add(1);
        test2.add(2);
        test2.add(3);
        test2.add(4);
        test2.add(5);
        test2.add(6);
        Numbers numbers = new Numbers(test2);

        List<Integer> test3 = new ArrayList<>();
        test3.add(45);
        test3.add(44);
        test3.add(43);
        test3.add(4);
        test3.add(5);
        test3.add(6);
        Numbers winningNumbers = new Numbers(test3);

        Menu.renewHits(numbers.calculateHits(winningNumbers));

        assertThat(Utils.getEarningsRate(1000, Menu.getWinningMoney()), is(400));
    }

    @Test
    public void 중복없는_랜덤_번호_테스트() {
        assertThat(Utils.generateRandomNumbers(6).size(), is(6));
    }

}
