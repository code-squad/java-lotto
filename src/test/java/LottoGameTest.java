import domain.LottoGame;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static domain.LottoGame.Rank;

public class LottoGameTest {
    LottoGame lottoGame;
    Map<Rank, Integer> target;

    @Before
    public void setup(){
        lottoGame = new LottoGame(14000);
        target = new HashMap<LottoGame.Rank, Integer>(){{
            put(Rank.FIRST,1);
            put(Rank.SECOND,2);
            put(Rank.THIRD,3);
            put(Rank.FOURTH,4);
            put(Rank.FIFTH,5);

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
        assertThat(lottoGame.generateLottoNum("1,2,3,4,5,6")).isEqualTo(luckyNum);
    }

    @Test
    public void replace() {
        LottoGame.Rank key = Rank.FOURTH;
        Map<LottoGame.Rank, Integer> result = new HashMap<LottoGame.Rank, Integer>(){{
            put(Rank.FIRST,1);
            put(Rank.SECOND,2);
            put(Rank.THIRD,3);
            put(Rank.FOURTH,5);
            put(Rank.FIFTH,5);
        }};

        assertThat(lottoGame.replace(target, key)).isEqualTo(result);
    }
}
