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

    @Test(expected = IllegalArgumentException.class)
    public void 중복된_숫자가_포함되면_예외가_발생한다() {
        //given
        List<Integer> duplicatedList = Arrays.asList(1, 1, 2, 3, 4, 5);

        //when
        new LottoTicket(duplicatedList);

        //then
        Assertions.fail("중복된 숫자로 로또 티켓 발급을 요청하면 예외가 발생해야 한다");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_숫자가_6자리가_아니면_예외가_발생한다() {
        //given
        List<Integer> notCompletedList = Arrays.asList(1);

        //when
        new LottoTicket(notCompletedList);

        //then
        Assertions.fail("중복된 숫자로 로또 티켓 발급을 요청하면 예외가 발생해야 한다");
    }
}
