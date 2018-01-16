import domain.LottoGame;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoGameTest {
    LottoGame lottoGame;

    @Before
    public void setup(){
        lottoGame = new LottoGame(14000);
    }

    @Test
    public void amountOfLotto(){
        assertThat(lottoGame.amountOfLotto(14000)).isEqualTo(14);
    }

    @Test
    public void compareLotto(){

    }

    @Test
    public void calRetRate() {
        int[] winCounts = {0,0,3,1,0,0};
        int money = 140000;

        assertThat(lottoGame.calRetRate(winCounts, money)).isEqualTo(-53);
    }
}
