package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningLottoTest {
    private List<Number> numbers;
    private Number bonusNumber;

    @Before
    public void setUp() {
        numbers = Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkDuplicateThrowException() {
        bonusNumber = new Number(6);
        WinningLotto.checkDuplicate(numbers, bonusNumber);
    }

    @Test
    public void createMatch() {
        List<Number> userNumbers = Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(7));
        Ticket ticket = new Ticket(userNumbers);

        numbers = new ArrayList<>(numbers);
        bonusNumber = new Number(7); //add bonus number 7
        numbers.add(bonusNumber);

        WinningLotto winningLotto = new WinningLotto(numbers);
        assertThat(winningLotto.createMatch(ticket)).isEqualTo(Match.SECOND); //5 numbers and bonus number match
    }
}