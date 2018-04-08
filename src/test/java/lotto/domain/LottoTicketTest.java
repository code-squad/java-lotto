package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoTicketTest {
    @Test
    public void 전달받은_로또티켓_번호와_일치하는_번호의_수를_반환한다() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoTicket lottoTicket = new LottoTicket(numbers);
        Collections.reverse(numbers);
        LottoTicket expected = new LottoTicket(numbers);

        //when
        long matched = lottoTicket.match(expected);

        //then
        Assertions.assertThat(matched).isEqualTo(6);
    }
}
