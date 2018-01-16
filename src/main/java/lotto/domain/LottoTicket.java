package lotto.domain;

/**
 * Created by Moonchan on 2018. 1. 13..
 */
public class LottoTicket {

    LottoNumber lottoNumber;

    public LottoTicket() {
        this(new AutoLottoNumberGenerator());
    }

    public LottoTicket(LottoNumberGenerator lottoNumberGenerator) {
        lottoNumber = new LottoNumber(lottoNumberGenerator.generateNumbers());
    }

    public Prize checkWinning(LottoNumber winningNumber) {
        int countMatchNumber = lottoNumber.countMatchNumber(winningNumber);
        if (countMatchNumber == LottoNumber.LOTTO_NUMBERS_SIZE) {
            return Prize.FIRST;
        }
        if (countMatchNumber == LottoNumber.LOTTO_NUMBERS_SIZE - 1) {
            return Prize.SECOND;
        }
        if (countMatchNumber == LottoNumber.LOTTO_NUMBERS_SIZE - 2) {
            return Prize.THIRD;
        }
        if (countMatchNumber == LottoNumber.LOTTO_NUMBERS_SIZE - 3) {
            return Prize.FOURTH;
        }

        return Prize.NONE;
    }
}
