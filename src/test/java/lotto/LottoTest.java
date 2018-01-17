package lotto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Joeylee on 2018-01-13.
 */
public class LottoTest {


    @Test(expected = IllegalArgumentException.class)
    public void 로또_숫자_최소갯수() throws Exception {
        List<Integer> numbers = Arrays.asList(1,2,3,4);

        Lotto lotto = new Lotto(numbers);
        System.out.println(lotto.toString());
    }

    @Test
    public void 로또_출력() throws Exception {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);

        Lotto lotto = new Lotto(numbers);
        System.out.println(lotto.toString());
    }

}