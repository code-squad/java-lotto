package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {
    @Test
    public void createLottoTicketTest() {
        Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.toString()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6).toString());
    }

    //당첨 번호를 입력 받으면 해당 로또가 몇개나 일치하는지 리턴
    @Test
    public void correspondNumsTest() {
        Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.correspondNums(Arrays.asList(2, 6, 4)))
                .isEqualTo(Arrays.asList(2, 6, 4));
    }

    @Test
    public void howManyCorrestpondTest() {
        Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.howManyCorrespond(Arrays.asList(2, 6, 4)))
                .isEqualTo(3);
    }
}
