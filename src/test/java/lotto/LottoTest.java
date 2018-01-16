package lotto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Joeylee on 2018-01-13.
 */
public class LottoTest {


    @Test
    public void 로또_출력() throws Exception {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        Lotto lotto = new Lotto(numbers);
        lotto.printLotto();
    }

}