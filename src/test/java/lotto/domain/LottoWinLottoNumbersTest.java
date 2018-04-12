package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinLottoNumbersTest {
    @Test(expected = IllegalArgumentException.class)
    public void 생성_bonusNumber1to45테스트() {
        new LottoWinNumbers(new LottoNumbers(1, 2, 3, 4, 5, 6), new LottoNumber(46));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 생성_bonusNumber중복withWinNumber테스트() {
        new LottoWinNumbers(new LottoNumbers(1, 2, 3, 4, 5, 6), new LottoNumber(6));
    }

    @Test
    public void match테스트() {
        LottoWinNumbers lottoWinNumbers = new LottoWinNumbers(new LottoNumbers(1, 2, 3, 4, 5, 6), new LottoNumber(7));
        assertThat(lottoWinNumbers.match(new Lotto(new LottoNumbers(1, 2, 3, 10, 8, 9))))
                .isEqualTo(LottoWinType.FIFTH);
        assertThat(lottoWinNumbers.match(new Lotto(new LottoNumbers(1, 2, 3, 4, 7, 9))))
                .isEqualTo(LottoWinType.SECOND);
    }
}
