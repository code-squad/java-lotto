package lotto;

import util.Utility;
import vo.Num;

import java.util.*;

public class WinningLotto {
    private Set<Num> winningLotto = new TreeSet<>();
    private Num bonusNum;

    public WinningLotto(String[] winningNumbers, Num bonusNum) {
        for (String winningNumber : winningNumbers) {
            winningLotto.add(new Num(Utility.fromStringToInteger(winningNumber)));
        }
        checkWinningNumbers();
        this.bonusNum = checkBonusNum(bonusNum);
    }

    private void checkWinningNumbers() {
        if (winningLotto.size() != 6)
            throw new IllegalArgumentException("중복된 숫자가 있거나 숫자를 모두 입력하지 않았습니다.");
    }

    private Num checkBonusNum(Num bonusNum) {
        if (winningLotto.contains(bonusNum))
            throw new IllegalArgumentException("보너번호와 당첨번호가 중복합니다.");
        return bonusNum;
    }

    public Lotto makeWinningLotto() {
        return new Lotto(winningLotto,bonusNum);
    }
}
