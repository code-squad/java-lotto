package lotto.domain;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.Before;
import org.junit.Test;

public class WinningLottoTest {

    private  WinningLotto winningLotto;

    @Before
    public void setUp() {
        winningLotto = new WinningLotto("1,2,3,4,5,6", 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void lottoResult_생성_에러_테스트() {
        winningLotto = new WinningLotto("",0);
        winningLotto = new WinningLotto("1,2,3,4,5,5,5,5,5,6",0);
        winningLotto = new WinningLotto("1,2,3,4,5,6",0);
    }


    @Test
    public void getBonus() {
        assertThat(winningLotto.getBonus()).isEqualTo(7);
    }

    @Test
    public void getWinningLottos() {
        assertThat(winningLotto.getWinningLottos().size()).isEqualTo(6);
    }
}