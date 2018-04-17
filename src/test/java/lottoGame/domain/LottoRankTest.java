package lottoGame.domain;

import org.junit.Test;
import org.junit.runner.notification.RunListener;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    @Test
    public void 로또RANK추출테스트() {

        LottoRank lottoRank = LottoRank.valueOf(5,true);
        assertThat(lottoRank).isEqualTo(LottoRank.SECOND);

        LottoRank lottoRank2 = LottoRank.valueOf(3,true);
        assertThat(lottoRank2).isEqualTo(LottoRank.FIFTH);

        LottoRank lottoRank3 = LottoRank.valueOf(4,true);
        assertThat(lottoRank3).isEqualTo(LottoRank.FOURTH);

    }

}