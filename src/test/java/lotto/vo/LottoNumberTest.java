package lotto.vo;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("NonAsciiCharacters")
public class LottoNumberTest {
    @Test(expected = IllegalArgumentException.class)
    public void 로또넘버_생성시_숫자_6개_미만_또는_초과이면_예외() {
        LottoNumber.of(Stream.of(1, 2, 3, 4, 5).collect(Collectors.toSet()));
        LottoNumber.of(Stream.of(1, 2, 3, 4, 5, 6, 7).collect(Collectors.toSet()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호중_중복된_번호가_있다면_예외() {
        LottoNumber.of(Stream.of(1, 2, 3, 3, 5, 6).collect(Collectors.toSet()));
    }

    @Test
    public void 동치성_테스트() {
        LottoNumber number1 = LottoNumber.of(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toSet()));
        LottoNumber number2 = LottoNumber.of(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toSet()));

        assertThat(number1).isEqualTo(number2);
    }

    @Test
    public void 특정숫자가_1부터45까지_숫자중_일부인지_확인() {
        assertThat(LottoNumber.isLottoNumber(1)).isTrue();
        assertThat(LottoNumber.isLottoNumber(11)).isTrue();
    }

    @Test
    public void 로또번호_일치_6개() {
        LottoNumber lottoNumber1 = LottoNumber.of(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toSet()));
        LottoNumber lottoNumber2 = LottoNumber.of(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toSet()));

        assertThat(lottoNumber1.matchCount(lottoNumber2)).isEqualTo(6);
    }

    @Test
    public void 로또번호_일치_1개() {
        LottoNumber lottoNumber1 = LottoNumber.of(Stream.of(1, 12, 13, 14, 15, 16).collect(Collectors.toSet()));
        LottoNumber lottoNumber2 = LottoNumber.of(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toSet()));

        assertThat(lottoNumber1.matchCount(lottoNumber2)).isEqualTo(1);
    }

    @Test
    public void 보너스_번호_일치() {
        LottoNumber lottoNumber1 = LottoNumber.of(Stream.of(1, 12, 13, 14, 15, 16).collect(Collectors.toSet()));
        assertThat(lottoNumber1.matchBonus(BonusNumber.of(16))).isTrue();
    }
}
