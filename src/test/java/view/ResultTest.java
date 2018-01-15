package view;

import domain.Lotto;
import domain.LottoFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    private Result result;

    @Before
    public void setup() {
        result = new Result(1000);
        LottoFactory.lottos = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void 로또를_산_갯수() {
        assertThat(result.countOfLotto()).isEqualTo(1);
    }

    @Test
    public void 못맞추거나_두개_이하로_맞췃을_때() {
        result.insertLastWinningNumbers("7, 8, 9, 10, 11, 12");
        assertThat(result.calRevenue()).isEqualTo(-100);
    }

    @Test
    public void 세개_맞췃을_때() {
        result.insertLastWinningNumbers("1, 2, 3, 10, 11, 12");
        assertThat(result.calRevenue()).isEqualTo(400);
    }

    @Test
    public void 네개_맞췃을_때() {
        result.insertLastWinningNumbers("1, 2, 3, 4, 11, 12");
        assertThat(result.calRevenue()).isEqualTo(4900);
    }

    @Test
    public void 다섯개_맞췃을_때() {
        result.insertLastWinningNumbers("1, 2, 3, 4, 5, 12");
        assertThat(result.calRevenue()).isEqualTo(149900);
    }

    @Test
    public void 여섯개_맞췃을_때() {
        result.insertLastWinningNumbers("1, 2, 3, 4, 5, 6");
        assertThat(result.calRevenue()).isEqualTo(199999900);
    }
}
