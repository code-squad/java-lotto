package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShopTest {

    @Test
    public void 낱개로또판매확인() {
        List<LottoNo> lottoNos = Arrays.asList(LottoNo.of(1), LottoNo.of(2), LottoNo.of(3), LottoNo.of(4), LottoNo.of(5), LottoNo.of(6));
        LottoNoGroup lottoNoGroup = LottoNoGroup.of(lottoNos);
        Lotto lotto = Lotto.of(lottoNoGroup);
        assertThat(Shop.sellTicket(lottoNoGroup), is(lotto));
    }
}
