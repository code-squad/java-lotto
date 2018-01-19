package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Moonchan on 2018. 1. 17..
 */
public class WinningNumberTest {

    private LottoTicket ticket;

    @Before
    public void setup() {
        ticket = new LottoTicket(new ManualLottoNumberGenerator(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void 정상생성() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningNumber winningNumber = new WinningNumber(numbers, 7);
        assertThat(winningNumber.getBonusNumber()).isEqualTo(7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 보너스숫자가_당첨숫자와_중복() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningNumber winningNumber = new WinningNumber(numbers, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 보너스숫자가_범위를_벗어남() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningNumber winningNumber = new WinningNumber(numbers, 50);
    }

    @Test
    public void 로또1등() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningNumber firstPrizeNumber = new WinningNumber(numbers, 7);
        assertThat(firstPrizeNumber.match(ticket)).isEqualTo(Prize.FIRST);
    }

    @Test
    public void 로또2등() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        WinningNumber secondPrizeNumber = new WinningNumber(numbers, 6);
        assertThat(secondPrizeNumber.match(ticket)).isEqualTo(Prize.SECOND);
    }

    @Test
    public void 로또3등() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        WinningNumber thirdPrizeNumber = new WinningNumber(numbers, 45);
        assertThat(thirdPrizeNumber.match(ticket)).isEqualTo(Prize.THIRD);
    }

    @Test
    public void 로또4등() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 7, 8);
        WinningNumber fourthPrizeNumber = new WinningNumber(numbers, 45);
        assertThat(fourthPrizeNumber.match(ticket)).isEqualTo(Prize.FOURTH);
    }

    @Test
    public void 로또5등() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 7, 8, 9);
        WinningNumber fifthPrizeNumber = new WinningNumber(numbers, 45);
        assertThat(fifthPrizeNumber.match(ticket)).isEqualTo(Prize.FIFTH);
    }

    @Test
    public void 노당첨() {
        List<Integer> numbers = Arrays.asList(7, 8, 9, 10, 11, 12);
        WinningNumber nonePrizeNumber = new WinningNumber(numbers, 45);
        assertThat(nonePrizeNumber.match(ticket)).isEqualTo(Prize.NONE);
    }
}