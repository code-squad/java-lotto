package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WinningLottoTest {

    @Test
    public void 보너스볼유효값검사_true() {
        List<LottoNo> lottoNos = Arrays.asList(LottoNo.of(1), LottoNo.of(2), LottoNo.of(3), LottoNo.of(4), LottoNo.of(5), LottoNo.of(6));
        LottoNoGroup lottoNoGroup = LottoNoGroup.of(lottoNos);
        assertThat(WinningLotto.isValidBonus(lottoNoGroup, LottoNo.of(7)), is(true));
    }

    @Test
    public void 보너스볼유효값검사_false() {
        List<LottoNo> lottoNos = Arrays.asList(LottoNo.of(1), LottoNo.of(2), LottoNo.of(3), LottoNo.of(4), LottoNo.of(5), LottoNo.of(6));
        LottoNoGroup lottoNoGroup = LottoNoGroup.of(lottoNos);
        assertThat(WinningLotto.isValidBonus(lottoNoGroup, LottoNo.of(6)), is(true));
    }

}
