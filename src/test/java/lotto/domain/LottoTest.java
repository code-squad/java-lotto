package lotto.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class LottoTest {

    @Test
    public void 로또_생성_값이_6개_있는지() {
        Lotto lotto = new Lotto();
        int count = 0;
        for (int i = 1; i < 46; i++) {
            if(lotto.contains(new LottoNumber(i))) {
                count++;
            }
        }
        assertEquals(6, count);
    }

    @Test(expected = NullPointerException.class)
    public void 사용자_지정_로또_생성_null() {
        String nullString = null;
        new Lotto(nullString);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 사용자_지정_로또_생성_모자란_List() {
        List<LottoNumber> numbers = new ArrayList<>();
        new Lotto(numbers);
    }

    @Test(expected = NullPointerException.class)
    public void 사용자_지정_로또_생성_null_List_포함() {
        List<LottoNumber> numbers = new ArrayList<>();
        numbers.add(null);
        numbers.add(new LottoNumber(2));
        new Lotto(numbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 사용자_지정_로또_생성_같은_숫자_List_포함() {
        List<LottoNumber> numbers = new ArrayList<>();
        numbers.add(new LottoNumber(1));
        numbers.add(new LottoNumber(1));
        numbers.add(new LottoNumber(3));
        numbers.add(new LottoNumber(4));
        numbers.add(new LottoNumber(5));
        numbers.add(new LottoNumber(6));
        new Lotto(numbers);
    }

    @Test
    public void 사용지_지정값과_생성값이_같은지() {
        List<LottoNumber> numbers = new ArrayList<>();
        IntStream.range(0,6).forEach(i->numbers.add(new LottoNumber(i+1)));
        Lotto customLotto = new Lotto(numbers);
        for (int i = 0; i < 5; i++) {
            assertTrue(customLotto.contains(new LottoNumber(i+1)));
        }

        for (int i = 0; i < 5; i++) {
            assertFalse(customLotto.contains(new LottoNumber(i+7)));
        }
    }
}