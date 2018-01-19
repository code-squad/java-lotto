package domain.lotto;

import DTO.LottoNumbers;
import DTO.LottoTickets;
import DTO.WinningResult;

public class LottoMachine {

    private Integer money;
    private LottoTicket winningTicket;
    private LottoTickets purchasedLottoTickets;

    public LottoMachine() {
        this.winningTicket = new LottoTicket(new LottoNumbers().createAutoNumbers());
    }

    public void insertMoney(String money) {
        this.money = Integer.parseInt(money);
        this.purchasedLottoTickets = new LottoTickets().createLottoTickets(this.calculatePurchaseTicketAmount());
    }

    private int calculatePurchaseTicketAmount() {
        return this.money / LottoTicket.PRICE;
    }

    public WinningResult getWinningResult(String text) {
        return new WinningResult(this.money, this.purchasedLottoTickets.findMatching(this.winningTicket.insertNumber(text)));
    }

    public LottoTicket getWinningTicket() {
        return this.winningTicket;
    }

    public Integer getMoney() {
        return money;
    }

    public LottoTickets getPurchasedLottoTicket() {
        return this.purchasedLottoTickets;
    }
}
