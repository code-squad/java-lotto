package domain;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnigLottoTest {
    @Test(expected = InputMismatchException.class)
    public void isDuplicationTest() {
        List<LottoNum> lottos = new ArrayList<>();
        for(int i = 1; i <= Lotto.LOTTO_NUMBER_COUNT; i++) {
            lottos.add(new LottoNum(i));
        }
        assertThat(new WinningLotto(lottos, new LottoNum(1)).isDuplicationBonusNumber(new LottoNum(1))).isTrue();
    }
}
