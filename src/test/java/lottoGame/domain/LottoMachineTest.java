package lottoGame.domain;

import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;


public class LottoMachineTest {

    @Test
    public void 로또금액을입력하면로또를발권한다() {
        LottoMachine lm = new LottoMachine();
        assertThat(lm.caculateLottoTiketCnt(14000)).isEqualTo(14);
    }

    @Test
    public void 발권받은로또를받아서로또를생성한다() {

        LottoMachine lm = new LottoMachine();
        Lotto[] lottoes = lm.giveLottoTiket(14000);
        assertThat(lottoes.length).isEqualTo(14);
    }

    @Test
    public void 발권받은로또가알맞은숫자인지확인한다() {
        LottoMachine lm = new LottoMachine();

        for(int k = 0; k < 10; k++) {

            ArrayList<Integer> lottoNums = lm.makeLottoNumbers();

            for (int i = 0; i < lottoNums.size() - 1; i++) {
                for (int j = i + 1; j < lottoNums.size(); j++) {
                    if (lottoNums.get(i) == lottoNums.get(j)) {
                        fail();
                    }
                }
            }

            for(int j:lottoNums) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    @Test
    public void 금액을입력받아티켓을발권받은후로또를생성한다() {

        LottoMachine lm = new LottoMachine();
        Lotto[] lottoes = lm.giveLottoTiket(14000);
        assertThat(lottoes.length).isEqualTo(14);

        for (int i = 0; i < lottoes.length; i++) {
            System.out.println(lottoes[i]);
        }
    }
}