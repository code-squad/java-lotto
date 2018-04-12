package lotto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {
    @Test
    public void 한라운드_생성_테스트() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        assertThat(lotto.getLotto().size()).isEqualTo(6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 당첨번호갯수미만오류확인() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 당첨번호갯수초과확인() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6, 7");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 당첨번호중복내역오류처리확인() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 1");
    }

    @Test
    public void 한장_전체매칭확인() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto winLotto = new Lotto("1, 2, 3, 4, 5, 6");

        int matchCount = lotto.getMatchCount(winLotto);
        assertThat(matchCount).isEqualTo(6);
    }

    @Test
    public void 한장_부분매칭확인() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 26");
        Lotto winLotto = new Lotto("1, 2, 3, 4, 5, 6");

        int matchCount = lotto.getMatchCount(winLotto);
        assertThat(matchCount).isEqualTo(5);
    }


}
