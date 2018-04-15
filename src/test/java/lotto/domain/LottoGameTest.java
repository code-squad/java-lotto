package lotto.domain;

import com.google.common.collect.Lists;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LottoGameTest {

    @Test
    public void 구매한_금액만큼_로또_생성() {
        LottoGame lottoGame = new LottoGame(14000, Lists.newArrayList());
        assertEquals(14, lottoGame.getPurchasedLottos().size());
    }
}
