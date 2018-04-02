import domain.LottoMain;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class LottoMainTest {
    // todo 1. 로또 구매 금액 입력받기
    // todo 2. 로또 금액을 1000(원)으로 나누기
    // todo 3. 로또 몇장 구매했는지 출력하기
    // todo 4. 로또 번호 생성하기 - 랜덤넘버
    // todo 5. 생성된 로또 번호들 출력하기


    @Test
    public void getPurchaseFee() {
        assertEquals(10000, LottoMain.getPurchaseFee());
    }

    @Test
    public void getTicketCount() {
        int purchaseFee = LottoMain.getPurchaseFee();
        assertEquals(10, LottoMain.getTicketCount(purchaseFee));
    }

    @Test
    public void getLottoTicket() {
        assertEquals(6, LottoMain.getLottoTicket().size());
    }

    @Test
    public void getLottoTickets() {
        assertEquals(10, LottoMain.getLottoTickets(LottoMain.getTicketCount(LottoMain.getPurchaseFee())).size());
    }
}
