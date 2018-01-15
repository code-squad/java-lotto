package lotto;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private Lotto lotto;

    @Before
    public void setUp() throws Exception {
        Set<Integer> number = new HashSet<>();
        number.add(1);
        number.add(2);
        number.add(3);
        number.add(4);
        number.add(5);
        number.add(6);
        lotto = new Lotto(number);
    }

    /**
     * TODO
     * 로또 발급
     * - 1~45 사이의 랜덤번호가 6개 배열로 발급된다.
     *   - 한번 나온 번호는다시 나올 수 없다.
     * - 결과 확인
     *   - 당첨 통계
     */

    @Test
    public void 로또_랜덤_생성() {
        lotto = new Lotto();
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @Test
    public void 로또_번호_생성() {
        assertThat(Lotto.LOTTO_NUMBERS.get(0)).isEqualTo(1);
        assertThat(Lotto.LOTTO_NUMBERS.get(10)).isEqualTo(11);
        assertThat(Lotto.LOTTO_NUMBERS.get(Lotto.LOTTO_NUMBERS.size()-1)).isEqualTo(45);
    }

    @Test
    public void joinNumbers() {
        assertThat(lotto.joinNumbers()).isEqualTo("1,2,3,4,5,6");
    }

    @Test
    public void getResult() {
        Set<Integer> winNums = new HashSet<>();
        winNums.add(1);
        winNums.add(2);
        winNums.add(3);
        winNums.add(4);
        winNums.add(6);
        winNums.add(13);
        assertThat(lotto.getResult(winNums).size()).isEqualTo(5);

    }

}