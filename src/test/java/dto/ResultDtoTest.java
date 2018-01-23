package dto;

import domain.Lotto;
import domain.Lottos;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultDtoTest {
    private ResultDto result;
    private Lottos lottos;

    @Before
    public void setup() {
        result = new ResultDto(1000, 0, new Lottos());
        lottos = new Lottos();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void 로또를_산_갯수() {
        assertThat(result.countOfLotto()).isEqualTo(1);
    }

    @Test
    public void 못맞추거나_두개_이하로_맞췃을_때() {
        result.checkLastWinningNumbers("7, 8, 9, 10, 11, 12", 45, lottos);
        assertThat(result.calRevenue()).isEqualTo(-100);
    }

    @Test
    public void 세개_맞췃을_때() {
        result.checkLastWinningNumbers("1, 2, 3, 10, 11, 12", 45, lottos);
        assertThat(result.calRevenue()).isEqualTo(400);
    }

    @Test
    public void 네개_맞췃을_때() {
        result.checkLastWinningNumbers("1, 2, 3, 4, 11, 12", 45, lottos);
        assertThat(result.calRevenue()).isEqualTo(4900);
    }

    @Test
    public void 다섯개_맞췃을_때() {
        result.checkLastWinningNumbers("1, 2, 3, 4, 5, 12", 45, lottos);
        assertThat(result.calRevenue()).isEqualTo(149900);
    }

    @Test
    public void 여섯개_맞췃을_때() {
        result.checkLastWinningNumbers("1, 2, 3, 4, 5, 6", 45, lottos);
        assertThat(result.calRevenue()).isEqualTo(199999900);
    }

    @Test
    public void 수동으로_진행해서_여섯개_맞췃을_때() {
        Lottos handLottos = new Lottos();
        handLottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        result = new ResultDto(1000, 1, handLottos);

        result.checkLastWinningNumbers("1, 2, 3, 4, 5, 6", 45, new Lottos());
        assertThat(result.calRevenue()).isEqualTo(199999900);
    }
}
