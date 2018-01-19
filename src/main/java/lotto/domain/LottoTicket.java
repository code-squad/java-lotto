package lotto.domain;

/**
 * Created by Moonchan on 2018. 1. 13..
 */
public class LottoTicket {

    public static final int TICKET_PRICE = 1000;

    private LottoNumber lottoNumber;

    public LottoTicket() {
        this(new AutoLottoNumberGenerator());
    }

    public LottoTicket(LottoNumberGenerator lottoNumberGenerator) {
        lottoNumber = new LottoNumber(lottoNumberGenerator.generateNumbers());
    }

    public Prize checkWinning(WinningNumber winningNumber) {
        return winningNumber.match(lottoNumber);
    }

    @Override
    public String toString() {
        return "[" + lottoNumber + "]";
    }
}
