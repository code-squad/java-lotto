package lotto;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

import java.util.List;

public class LottoMachineTest {
    @SuppressWarnings("NonAsciiCharacters")
    @Test
    public void make_lottos_1개_찍어내기() {
        assertThat(LottoMachine.publishLotto(1)).hasSize(1);
    }

    @SuppressWarnings("NonAsciiCharacters")
    @Test
    public void make_lottos_14개_찍어내기() {
        assertThat(LottoMachine.publishLotto(14)).hasSize(14);
    }


    @Test
    public void name() {
        List<Lotto> lottoList = LottoMachine.publishLotto(5);
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }
}
