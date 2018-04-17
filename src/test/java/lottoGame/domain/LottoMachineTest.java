package lottoGame.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;


public class LottoMachineTest {

    @Test
    public void 로또금액을입력하면로또를발권한다() {
        LottoMachine lm = new LottoMachine();
        assertThat(lm.caculateLottoTiketCount(14000,0)).isEqualTo(14);
    }

    @Test
    public void 발권받은로또를받아서로또를생성한다() {

        LottoMachine lm = new LottoMachine();
        List<Lotto> lottoes = lm.getLottoTiket(14000,0);
        assertThat(lottoes.size()).isEqualTo(14);
    }

    @Test
    public void 금액을입력받아티켓을발권받은후로또를생성한다() {

        LottoMachine lm = new LottoMachine();
        List<Lotto> lottoes = lm.getLottoTiket(14000,0);
        assertThat(lottoes.size()).isEqualTo(14);

        for (int i = 0; i < lottoes.size(); i++) {
            System.out.println(lottoes.get(i));
        }
    }

    @Test(expected=IllegalArgumentException.class)
    public void 수동으로입력받은갯수가금액을초과할경우예외발생확인() {

        LottoMachine lm = new LottoMachine();
        List<Lotto> lottoes = lm.getLottoTiket(14000,20);
    }
}