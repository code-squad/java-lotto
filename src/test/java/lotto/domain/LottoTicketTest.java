package lotto.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Moonchan on 2018. 1. 16..
 */
public class LottoTicketTest {

    @Test
    public void 당첨여부확인() {
        LottoTicket ticket = new LottoTicket(new ManualLottoNumberGenerator(1, 2, 3, 4, 5, 6));

        LottoNumber firstPrizeNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        Prize prize = ticket.checkWinning(firstPrizeNumber);
        assertThat(prize).isEqualTo(Prize.FIRST);

        LottoNumber secondPrizeNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 7));
        prize = ticket.checkWinning(secondPrizeNumber);
        assertThat(prize).isEqualTo(Prize.SECOND);

        LottoNumber nonePrizeNumber = new LottoNumber(Arrays.asList(7, 8, 9, 10, 11, 12));
        prize = ticket.checkWinning(nonePrizeNumber);
        assertThat(prize).isEqualTo(Prize.NONE);
    }
}