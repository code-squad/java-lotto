package lotto.domain;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 로또는_숫자_6개를_가진다() {
        IntStream
            .range(0, 100)
            .forEach(i -> {
                assertThat(new Lotto().size())
                        .isEqualTo(Lotto.NUMBER_COUNT);
            });
    }

    @Test
    public void name() {
        Lotto lotto = new Lotto(null);

        assertThat(lotto.size())
                .isEqualTo(0);
    }
}