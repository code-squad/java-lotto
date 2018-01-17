package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {
    private Lotto lotto;

    @Before
    public void init() {
        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void createLottoTicketTest() {
        assertThat(lotto.toString()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6).toString());
    }

    //당첨 번호를 입력 받으면 해당 로또가 몇개나 일치하는지 리턴
    @Test
    public void correspondNumsTest() {
        assertThat(lotto.correspondNums(Arrays.asList(2, 6, 4)))
                .isEqualTo(Arrays.asList(2, 6, 4));
    }

    @Test
    public void howManyCorrestpondTest() {
        assertThat(lotto.howManyCorrespond(Arrays.asList(2, 6, 4)))
                .isEqualTo(3);
    }

    @Test
    public void isBonusNumMatchTest() {
        assertThat(lotto.isBonusNumMatch(6)).isEqualTo(true);
    }
}
