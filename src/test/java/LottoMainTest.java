import domain.LottoMain;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LottoMainTest {
    // todo 1. 로또 구매 금액 입력받기
    // todo 2. 로또 금액을 1000(원)으로 나누기
    // todo 3. 로또 몇장 구매했는지 출력하기


    @Test
    public void getPurchaseFee() {
        assertEquals(10000, LottoMain.getPurchaseFee());
    }

    @Test
    public void getTicketCount() {
        int purchaseFee = LottoMain.getPurchaseFee();
        assertEquals(10, LottoMain.getTicketCount(purchaseFee));
    }
}
