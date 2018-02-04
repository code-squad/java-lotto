package domain.lotto;

import dto.LottoMoney;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class LottoMoneyTest {

    @Test
    public void getPurchasingTicketAmount(){
        LottoMoney lottoMoney = LottoMoney.of(10000);
        assertThat(lottoMoney.getPurchasingTicketAmount(), is(10));
    }
}
