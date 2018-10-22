package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTest {
    @Test
    public void matchLottoTest() {
        List<LottoNum> lottoNums = new ArrayList<>();
        for(int i = 1; i <= Lotto.LOTTO_NUMBER_COUNT; i++) {
            lottoNums.add(new LottoNum(i));
        }
        Lotto lotto = new Lotto(lottoNums);
        Lotto winnigLotto = LottoFactory.createLotto("1, 2, 3, 4, 5, 6");
        assertThat(lotto.matchLotto(winnigLotto)).isEqualTo(6);
    }
}
