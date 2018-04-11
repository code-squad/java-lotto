package lotto.domain;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LottoTest {

    @Test
    public void 구매한_갯수만큼_로또_생성() {
        List<LottoNumber> lottos = Lotto.create(14);
        assertEquals(14, lottos.size());
    }
}
