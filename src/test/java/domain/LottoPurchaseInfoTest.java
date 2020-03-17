package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPurchaseInfoTest {

    @Test
    public void 로또구매정보생성() {
        //given
        LottoGenerator lottoGenerator = new AutoLottoGenerator();

        //when
        LottoPurchaseInfo purchaseInfo1 = new LottoPurchaseInfo(1000, lottoGenerator);
        LottoPurchaseInfo purchaseInfo2 = new LottoPurchaseInfo(5000, lottoGenerator);

        //then
        assertThat(purchaseInfo1.getLottos().size()).isEqualTo(1);
        assertThat(purchaseInfo2.getLottos().size()).isEqualTo(5);
    }
}
