package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LottoNoGroupTest {

    @Test
    public void 중복값검사_true() {
        List<LottoNo> lottoNos = Arrays.asList(LottoNo.of(1), LottoNo.of(2), LottoNo.of(3), LottoNo.of(4), LottoNo.of(5), LottoNo.of(6));
        assertThat(LottoNoGroup.hasDuplication(lottoNos), is(true));
    }

    @Test
    public void 중복값검사_false() {
        List<LottoNo> lottoNos = Arrays.asList(LottoNo.of(1), LottoNo.of(1), LottoNo.of(3), LottoNo.of(4), LottoNo.of(5), LottoNo.of(6));
        assertThat(LottoNoGroup.hasDuplication(lottoNos), is(false));
    }

    @Test
    public void 사이즈검사_true() {
        List<LottoNo> lottoNos = Arrays.asList(LottoNo.of(1), LottoNo.of(2), LottoNo.of(3), LottoNo.of(4), LottoNo.of(5), LottoNo.of(6));
        assertThat(LottoNoGroup.isValidSize(lottoNos), is(true));
    }

    @Test
    public void 사이즈검사_false() {
        List<LottoNo> lottoNos = Arrays.asList(LottoNo.of(1), LottoNo.of(2), LottoNo.of(3), LottoNo.of(4), LottoNo.of(5), LottoNo.of(6), LottoNo.of(7));
        assertThat(LottoNoGroup.isValidSize(lottoNos), is(false));
    }

    @Test
    public void countMatch() {
        List<LottoNo> lottoNos = Arrays.asList(LottoNo.of(1), LottoNo.of(2), LottoNo.of(3), LottoNo.of(4), LottoNo.of(5), LottoNo.of(6));
        LottoNoGroup lottoNoGroup = LottoNoGroup.of(lottoNos);
        List<LottoNo> winningLottoNos = Arrays.asList(LottoNo.of(1), LottoNo.of(2), LottoNo.of(3), LottoNo.of(4), LottoNo.of(5), LottoNo.of(6));
        LottoNoGroup winningLottoNoGroup = LottoNoGroup.of(winningLottoNos);
        assertThat(lottoNoGroup.countMatch(winningLottoNoGroup), is(6));
    }

}
