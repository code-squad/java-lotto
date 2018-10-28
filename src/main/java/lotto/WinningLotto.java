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
            throw new IllegalArgumentException("중복된 숫자가 있거나 숫자6개가 아닙니다.");
    }

    public Lotto makeWinningLotto() {
        return new Lotto(winningLotto);
    }
}
