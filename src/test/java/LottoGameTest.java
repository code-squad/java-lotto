import domain.LottoGame;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class LottoGameTest {
    LottoGame lottoGame;
    Map<LottoGame.Rank, Integer> target;

    @Before
    public void setup(){
        lottoGame = new LottoGame(14000);
        target = new HashMap<LottoGame.Rank, Integer>(){{
            put(LottoGame.Rank.FIRST,1);
            put(LottoGame.Rank.SECOND,2);
            put(LottoGame.Rank.THIRD,3);
            put(LottoGame.Rank.FOURTH,4);
            put(LottoGame.Rank.FIFTH,5);

        }};
    }

    @Test
    public void amountOfLotto(){
        assertThat(lottoGame.amountOfLotto(14000)).isEqualTo(14);
    }

    @Test
    public void calRetRate() {

        int money = 140000;

        assertThat(lottoGame.calRetRate(target, money)).isEqualTo(1477917);
    }

    @Test
    public void generateLuckyNum() {
        List luckyNum = Arrays.asList(1,2,3,4,5,6);
        assertThat(lottoGame.generateLuckyNum("1,2,3,4,5,6")).isEqualTo(luckyNum);
    }

    @Test
    public void replace() {
        LottoGame.Rank key = LottoGame.Rank.FOURTH;
        Map<LottoGame.Rank, Integer> result = new HashMap<LottoGame.Rank, Integer>(){{
            put(LottoGame.Rank.FIRST,1);
            put(LottoGame.Rank.SECOND,2);
            put(LottoGame.Rank.THIRD,3);
            put(LottoGame.Rank.FOURTH,5);
            put(LottoGame.Rank.FIFTH,5);
        }};

        assertThat(lottoGame.replace(target, key)).isEqualTo(result);
    }
}
