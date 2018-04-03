package saru.domain;

import saru.Rank;

import java.util.*;

public class WinningLotto {
    private List<LottoNum> winningNumbers;
    private int bonusNumber;

    private WinningLotto(List<LottoNum> numbers, int bonusNumer) {
        this.winningNumbers = numbers;
        this.bonusNumber = bonusNumer;
    }

    public static WinningLotto of(List<LottoNum> hitLottoLine, int bonusNumer) {
        return new WinningLotto(hitLottoLine, bonusNumer);
    }

    List<LottoNum> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
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
        return lottoLine.getNumbers().contains(LottoNum.of(bonusNumber));
    }
}