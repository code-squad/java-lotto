package lotto;

import lotto.exception.DuplicatedBonusNumberException;
import lotto.exception.IllegalLottoNumberFormatException;

import java.util.List;

public class Lotto {
    protected static final int LOTTO_SIZE = 6;
    private List<LottoNumber> lottoTicket;

    protected Lotto(List<LottoNumber> lottoTicket) {
        if (lottoTicket == null || lottoTicket.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (lottoTicket.size() != LOTTO_SIZE) {
            throw new IllegalLottoNumberFormatException();
        }

        this.lottoTicket = lottoTicket;
    }

    public int checkDuplicateBonusNumber(int bonus) {
        if (isContainsBonusNumber(bonus)) {
            throw new DuplicatedBonusNumberException();
        }
        return bonus;
    }

    public boolean isContainsBonusNumber(int bonus) {
        return this.lottoTicket.contains(new LottoNumber(bonus));
    }

    public int countMatchLottoNumber(Lotto lotto) {
        int matchCount = 0;
        for (LottoNumber lottoNumber : this.lottoTicket) {
            matchCount += containsLottoNumber(lottoNumber, lotto);
        }
        return matchCount;
    }

    public int containsLottoNumber(LottoNumber lottoNumber, Lotto lotto) {
        return lotto.lottoTicket.contains(lottoNumber) ? 1 : 0;
    }

    public String toString() {
        return lottoTicket.toString();
    }

}