package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Moonchan on 2018. 1. 18..
 */
public class PrizeTest {

    private LottoNumber lottoNumber;

    @Before
    public void setup() {
        lottoNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void 로또1등() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningNumber firstPrizeNumber = new WinningNumber(new LottoNumber(numbers), 7);
        Prize prize = Prize.checkWinning(lottoNumber, firstPrizeNumber);
        assertThat(prize).isEqualTo(Prize.FIRST);
    }

    @Test
    public void 로또2등() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        WinningNumber secondPrizeNumber = new WinningNumber(new LottoNumber(numbers), 6);
        Prize prize = Prize.checkWinning(lottoNumber, secondPrizeNumber);
        assertThat(prize).isEqualTo(Prize.SECOND);
    }

    @Test
    public void 로또3등() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        WinningNumber thirdPrizeNumber = new WinningNumber(new LottoNumber(numbers), 45);
        Prize prize = Prize.checkWinning(lottoNumber, thirdPrizeNumber);
        assertThat(prize).isEqualTo(Prize.THIRD);
    }

    @Test
    public void 로또4등() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 7, 8);
        WinningNumber fourthPrizeNumber = new WinningNumber(new LottoNumber(numbers), 45);
        Prize prize = Prize.checkWinning(lottoNumber, fourthPrizeNumber);
        assertThat(prize).isEqualTo(Prize.FOURTH);
    }

    @Test
    public void 로또5등() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 7, 8, 9);
        WinningNumber fifthPrizeNumber = new WinningNumber(new LottoNumber(numbers), 45);
        Prize prize = Prize.checkWinning(lottoNumber, fifthPrizeNumber);
        assertThat(prize).isEqualTo(Prize.FIFTH);
    }

    @Test
    public void 노당첨() {
        List<Integer> numbers = Arrays.asList(7, 8, 9, 10, 11, 12);
        WinningNumber nonePrizeNumber = new WinningNumber(new LottoNumber(numbers), 45);
        Prize prize = Prize.checkWinning(lottoNumber, nonePrizeNumber);
        assertThat(prize).isEqualTo(Prize.NONE);
    }
}
