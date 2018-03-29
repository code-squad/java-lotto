package lotto.lotto.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LottoUtilsTest {

    @Test
    public void createNumber() {
        assertThat(LottoUtils.createNumber().size(), is(45));
    }

    @Test
    public void selectSixNumberTest() {
        List<Integer> test = new ArrayList<Integer>(Arrays.asList(35, 23, 2, 42, 21, 13, 41, 20));
        List<Integer> test2 = new ArrayList<Integer>(Arrays.asList(35, 23, 2, 42, 21, 13));
        assertThat(test2, is(LottoUtils.selectSixNumber(test)));
    }

    @Test
    public void sortNumberTest() {
        List<Integer> test = new ArrayList<Integer>(Arrays.asList(15, 5, 23, 7));
        List<Integer> test2 = new ArrayList<Integer>(Arrays.asList(5, 7, 15, 23));

        assertThat(test2, is(LottoUtils.sortNumber(test)));
    }
}