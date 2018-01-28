package domain.lotto;

import dto.LottoMoney;
import dto.LottoTickets;
import dto.WinningResult;

public class LottoMachine {

    private LottoMoney lottoMoney;
    private LottoTickets purchasedLottoTickets;

    private LottoMachine(int money, int manualBuyNumber) {
        this.lottoMoney = LottoMoney.of(money);
        this.purchasedLottoTickets = LottoTickets.of(this.lottoMoney.getPurchasingTicketAmount(), manualBuyNumber);
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

    public static LottoMachine of(int money, int manualBuyNumber) {
        return new LottoMachine(money, manualBuyNumber);
    }
}
