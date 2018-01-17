import domain.LottoGame;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class LottoGameTest {
    LottoGame lottoGame;
    Map<Integer, Integer> target;

    @Before
    public void setup(){
        lottoGame = new LottoGame(14000);
        target = new HashMap<Integer, Integer>(){{
            put(3,3);
            put(4,1);
            put(5,0);
            put(6,0);
        }};
    }

    @Test
    public void amountOfLotto(){
        assertThat(lottoGame.amountOfLotto(14000)).isEqualTo(14);
    }

    @Test
    public void calRetRate() {

        int money = 140000;

        assertThat(lottoGame.calRetRate(target, money)).isEqualTo(-53);
    }

    @Test
    public void generateLuckyNum() {
        List luckyNum = Arrays.asList(1,2,3,4,5,6);
        assertThat(lottoGame.generateLuckyNum("1,2,3,4,5,6")).isEqualTo(luckyNum);
    }

    @Test
    public void replace() {
        int key = 3;
        Map<Integer, Integer> result = new HashMap<Integer, Integer>(){{
            put(3,4);
            put(4,1);
            put(5,0);
            put(6,0);
        }};

        assertThat(lottoGame.replace(target, key)).isEqualTo(result);
    }
}
