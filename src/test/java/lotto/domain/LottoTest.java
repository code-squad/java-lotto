package lotto.domain;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class LottoTest {

    @Test
    public void 로또_생성_값이_6개_있는지() {
        Lotto lotto = new Lotto();
        int[] count = {0};
        IntStream.range(1, 45).forEach(i-> {
            if (lotto.contains(new LottoNumber(i))) {
                count[0]++;
            }
        });
        assertEquals(6, count[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 사용자_지정_로또_생성_null() {
        new Lotto(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 사용자_지정_로또_생성_빈_배열() {
        LottoNumber[] numbers = new LottoNumber[]{};
        new Lotto(numbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 사용자_지정_로또_생성_모자란_배열() {
        LottoNumber[] numbers = new LottoNumber[]{new LottoNumber(1)};
        new Lotto(numbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 사용자_지정_로또_생성_null_배열_포함() {
        LottoNumber[] numbers = new LottoNumber[]{null, new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)};
        new Lotto(numbers);
    }

    @Test
    public void 사용지_지정값과_동일한_값을_갖고_있는지() {
        LottoNumber[] numbers = new LottoNumber[6];
        IntStream.range(0,6).forEach(i->numbers[i]=new LottoNumber(i+1));
        Lotto customLotto = new Lotto(numbers);
        for (int i = 0; i < 5; i++) {
            assertTrue(customLotto.contains(new LottoNumber(i+1)));
        }

        for (int i = 0; i < 5; i++) {
            assertFalse(customLotto.contains(new LottoNumber(i+7)));
        }
    }
}