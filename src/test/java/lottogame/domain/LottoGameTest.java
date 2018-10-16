package lottogame.domain;

import lottogame.util.LottoRandom;
import lottogame.util.NumberGenerator;
import lottogame.dto.ResultDTO;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    @Test
    public void buyLotto() {
        LottoGame lottoGame = new LottoGame(14000, new LottoRandom());
        assertThat(lottoGame.countLotto()).isEqualTo(14);
    }

    @Test
    public void checkLotto() {
        //로또 9개 생성
        LottoGame lottoGame = new LottoGame(9000, new NumberGenerator() {
            private int cnt = 0;
            @Override
            //2,3,4등을 차례대로 생성
            public List<Integer> generate() {
                cnt++;
                if(cnt%3 == 0) return Arrays.asList(1, 2, 3, 10, 11, 12);
                if(cnt%3 == 1) return Arrays.asList(1, 2, 3, 4, 11, 12);
                return Arrays.asList(1, 2, 3, 4, 5, 12);
            }
        });
        ResultDTO resultDTO = lottoGame.result(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(resultDTO.getHitCountOf(PrizeRank.FIRST_PLACE)).isEqualTo(0);
        assertThat(resultDTO.getHitCountOf(PrizeRank.SECOND_PLACE)).isEqualTo(3);
        assertThat(resultDTO.getHitCountOf(PrizeRank.THIRD_PLACE)).isEqualTo(3);
        assertThat(resultDTO.getHitCountOf(PrizeRank.FOURTH_PLACE)).isEqualTo(3);
    }
}
