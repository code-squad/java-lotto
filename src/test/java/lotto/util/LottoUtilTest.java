package lotto.util;

import lotto.domain.Lotto;

import org.junit.Test;
import org.slf4j.Logger;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class LottoUtilTest {
    private static final Logger log = getLogger(LottoUtilTest.class);
    private LottoUtil lottoUtil = new LottoUtil();

    @Test
    public void lottoNumber() {
       assertThat(lottoUtil.lottoNumber().size()).isEqualTo(45);
    }

    @Test
    public void oneLottoPage() {
//        assertThat(LottoUtil.oneLottoPage().size()).isEqualTo(6);
    }

    @Test
    public void lotto() {
        int a = 5;
        for (Lotto lotto : lottoUtil.lottoObject(a)) {
            System.out.println(lotto);
        }
    }

    @Test
    public void ranks() {
        assertThat(lottoUtil.ranks().get(0).getCountOfMatch()).isEqualTo(3);
    }
}