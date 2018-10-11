package lotto.domain;

import lotto.domain.LottoNo;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNoTest {
    @Test(expected = IllegalArgumentException.class)
    public void 범위미만숫자입력() {
        LottoNo lottoNo = new LottoNo(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 범위초과숫자입력() {
        LottoNo lottoNo = new LottoNo(0);
    }

    @Test
    public void 범위적정숫자입력() {
        LottoNo lottoNo = new LottoNo(1);
    }

    @Test
    public void equals검사() {
        LottoNo lottoNo1 = new LottoNo(1);
        LottoNo lottoNo2 = new LottoNo(1);

        assertThat(lottoNo1.equals(lottoNo2)).isEqualTo(true);
    }
}
