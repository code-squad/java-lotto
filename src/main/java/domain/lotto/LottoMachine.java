package domain.lotto;

import dto.LottoTickets;
import dto.WinningResult;

public class LottoMachine {

    private Integer money;

    private LottoTickets purchasedLottoTickets;

    public LottoMachine(String money) {
        this.money = Integer.parseInt(money);
        this.purchasedLottoTickets = new LottoTickets(this.calculatePurchaseTicketAmount());
    }

    private int calculatePurchaseTicketAmount() {
        return this.money / LottoTicket.PRICE;
    }

    public WinningResult getWinningResult(String text) {
        return new WinningResult(this.money, this.purchasedLottoTickets.findMatching(new LottoTicket(text)));
    }

    public Integer getMoney() {
        return money;
    }

    public LottoTickets getPurchasedLottoTicket() {
        return this.purchasedLottoTickets;
    }
}
