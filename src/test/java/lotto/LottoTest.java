package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class LottoTest {

    Lotto lotto;

    @Before
    public void setUp() {
        lotto = new Lotto(() -> Arrays.asList(8, 10, 11, 24, 33,45));
    }

    @Test
    public void test_로또_생성시_숫자_6개로_이뤄진_리스트가_만들어진다() {
        assertThat(lotto.numbers).isNotEmpty().hasSize(6);
    }

    @Test
    public void test_로또번호는_1부터45까지의_숫자다() {
        for (int number : lotto.numbers) {
            assertThat(number).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(45);
        }
    }

    @Test
    public void test_당첨번호_입력시_5등당첨여부_확인() {
        assertThat(lotto.matchesNumber(Arrays.asList(8, 10, 11, 31, 32, 44))).isEqualTo(3);
    }

    @Test
    public void test_당첨번호_입력시_4등당첨여부_확인() {
        assertThat(lotto.matchesNumber(Arrays.asList(8, 10, 11, 24, 32, 44))).isEqualTo(4);
    }

    @Test
    public void test_당첨번호_입력시_1등당첨여부_확인() {
        assertThat(lotto.matchesNumber(Arrays.asList(8, 10, 11, 24, 33, 45))).isEqualTo(6);
    }
}
