package lotto.domain;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 로또는_숫자_6개를_가진다() {
        IntStream
            .range(0, 100)
            .forEach(i -> {
                Lotto lotto = new Lotto();
                List<Integer> numbers = lotto.getNumbers();

                assertThat(numbers)
                        .hasSize(Lotto.NUMBER_COUNT);
            });
    }

    @Test
    public void 로또_숫자는_1부터_45까지_값을_갖는다() {
        TestLotto testLotto = new TestLotto();
        List<Integer> numbers = testLotto.getNumbers();

        assertThat(numbers)
                .filteredOn(number -> Lotto.MIN_NUMBER <= number && number <= Lotto.MAX_NUMBER)
                .hasSize(Lotto.NUMBER_COUNT);
    }

    private class TestLotto extends Lotto {
        List<Integer> createNumbers() {
            return Lists.newArrayList(1, 2, 3, 4, 5, 6);
        }
    }
}