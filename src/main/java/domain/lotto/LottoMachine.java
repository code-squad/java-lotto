package domain.lotto;

import DTO.WinningResult;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private Integer money;
    private LottoTicket winningTicket;
    private List<LottoTicket> purchasedLottoTickets;

    public LottoMachine() {
        this.winningTicket = new LottoTicket();
    }

    public void insertMoney(String money) {
        this.money = Integer.parseInt(money);
    }

    public void buyLottoTicket() {
        this.purchasedLottoTickets = createLottoTicket(calculatePurchaseTicketAmount());
    }

    private int calculatePurchaseTicketAmount() {
        return this.money / LottoTicket.PRICE;
    }

    public List<LottoTicket> createLottoTicket(Integer amount) {
        List<LottoTicket> tickets = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            tickets.add(new LottoTicket());
        }
        return tickets;
    }

    public void inputWinningNumber(String numbers) {
        this.winningTicket.insertNumber(numbers);
    }

    public WinningResult findMatching() {
        return new WinningResult(this.money, this.winningTicket, this.purchasedLottoTickets);
    }

    public LottoTicket getWinningTicket() {
        return this.winningTicket;
    }

    public Integer getMoney() {
        return money;
    }

    public List<LottoTicket> getPurchasedLottoTicket() {
        return this.purchasedLottoTickets;
    }
}
