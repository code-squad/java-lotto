package lotto;

import util.Utility;
import vo.Num;

import java.util.*;

public class WinningLotto {
    private Set<Num> winningLotto = new TreeSet<>();

    public WinningLotto(String[] winningNumbers) {
        for (String winningNumber : winningNumbers) {
            winningLotto.add(new Num(Utility.fromStringToInteger(winningNumber)));
        }
        if (winningLotto.size() != 6)
            throw new IllegalArgumentException("중복된 숫자가 있거나 숫자를 모두 입력하지 않았습니다.");
    }

    public Num BonusCheck(Num BonusNum) {
        if (winningLotto.contains(BonusNum))
            throw new IllegalArgumentException("보너번호와 당첨번호가 중복합니다.");
        return BonusNum;
    }

    public Lotto makeWinningLotto() {
        return new Lotto(winningLotto);
    }
}
