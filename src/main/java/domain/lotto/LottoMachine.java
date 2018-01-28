package domain.lotto;

import dto.LottoMoney;
import dto.LottoTickets;
import dto.WinningResult;

public class LottoMachine {

    private LottoMoney lottoMoney;
    private LottoTickets purchasedLottoTickets;

    private LottoMachine(Money money) {
        this.lottoMoney = new LottoMoney(money);
        this.purchasedLottoTickets = new LottoTickets(this.lottoMoney.getPurchasingTicketAmount());
    }

    public WinningResult getWinningResult(InputString inputString, LottoNumber bonusBallNumber) {
        return new WinningResult(this.lottoMoney, this.purchasedLottoTickets.findMatching(LottoTicket.of(inputString), bonusBallNumber));
    }

    public Integer getMoney() {
        return lottoMoney.getMoney();
    }

    public LottoTickets getPurchasedLottoTicket() {
        return this.purchasedLottoTickets;
    }

    public static LottoMachine of(int money) {
        return new LottoMachine(Money.of(money));
    }
}
