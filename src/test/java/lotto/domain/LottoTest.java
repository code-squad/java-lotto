package lotto.domain;

import lotto.exception.DuplicatedNumberException;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private Lotto lotto;

    @Before
    public void setUp() throws Exception {
        List<LottoNo> number = new ArrayList<>(Arrays.asList(new LottoNo(6)
            ,new LottoNo(1)
            ,new LottoNo(2)
            ,new LottoNo(3)
            ,new LottoNo(4)
            ,new LottoNo(5)));
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

    @Test(expected = DuplicatedNumberException.class)
    public void 로또_중복_생성() {
        List<LottoNo> number = new ArrayList<>(Arrays.asList(new LottoNo(6)
                ,new LottoNo(1)
                ,new LottoNo(2)
                ,new LottoNo(3)
                ,new LottoNo(3)
                ,new LottoNo(3)));
        lotto = new Lotto(number);
    }

    @Test
    public void 로또_번호_중복() {
        lotto = new Lotto();
    }

    @Test
    public void 로또_번호_생성() {
        assertThat(Lotto.LOTTO_NUMBER_RANGE.get(0)).isEqualTo(1);
        assertThat(Lotto.LOTTO_NUMBER_RANGE.get(10)).isEqualTo(11);
        assertThat(Lotto.LOTTO_NUMBER_RANGE.get(Lotto.LOTTO_NUMBER_RANGE.size()-1)).isEqualTo(45);
    }

    @Test
    public void joinNumbers() {
        assertThat(lotto.joinNumbers()).isEqualTo("1,2,3,4,5,6");
    }

}