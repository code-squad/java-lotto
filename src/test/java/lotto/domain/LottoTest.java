package lotto.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void 로또는_숫자_6개를_가진다() {
        IntStream
            .range(0, 100)
            .forEach(i -> {
                assertThat(new Lotto().size())
                        .isEqualTo(LottoRule.NUMBER_COUNT);
            });
    }

    @Test
    public void null_로또_처리() {
        thrown.expect(IllegalArgumentException.class);

        Lotto lotto = new Lotto(null);

        assertThat(lotto.size())
                .isEqualTo(0);
    }

    @Test
    public void 로또가_가진_번호를_문자열로_출력() {
        Lotto lotto = new Lotto(Arrays.asList("1", "2", "3", "4", "5", "6"));

        assertThat(lotto.toString())
                .isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    public void 로또가_소유한_번호인가() {
        Lotto lotto = new Lotto(Arrays.asList("1", "2", "3", "4", "5", "6"));

        assertThat(lotto.contains("6"))
                .isTrue();
    }
}