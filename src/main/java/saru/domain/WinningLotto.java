package saru.domain;

import java.util.*;

public class WinningLotto {
    private List<LottoNum> winningNumbers;
    private LottoNum bonusNumber;

    private WinningLotto(List<LottoNum> numbers, LottoNum bonusNumber) {
        this.winningNumbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(List<LottoNum> hitLottoLine, LottoNum bonusNumber) {
        return new WinningLotto(hitLottoLine, bonusNumber);
    }

    private boolean checkContain(LottoNum lottoNum) {
        return winningNumbers.contains(lottoNum);
    }

    public int match(LottoLine lottoLine) {
        int matchNum = 0;
        for (LottoNum lottoNum : lottoLine.getNumbers()) {
            if (checkContain(lottoNum)) {
                matchNum++;
            }
        }

        return matchNum;
    }

    public boolean matchBonus(LottoLine lottoLine) {
        return lottoLine.getNumbers().contains(bonusNumber);
    }
}