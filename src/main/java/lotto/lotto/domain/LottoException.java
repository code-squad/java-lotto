package lotto.lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LottoException {

    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int NUMBER = 6;
    private static final int LOTTO = 1000;
    private static final int ZERO = 0;

    public static void overException(int lottoNumber) {
        if (lottoNumber < MIN || MAX < lottoNumber)
            throw new IllegalArgumentException("1부터 45까지만 입력해 주세요.");
    }

    public static void notLottoException(String[] numbers) {
        if (numbers.length != NUMBER)
            throw new IllegalArgumentException("당첨 번호가 잘못 입력 되었습니다");
    }

    public static void sameNumberException(List<Integer> winningLotto) {
        HashSet<Integer> set = new HashSet<>(winningLotto);
        if (winningLotto.size() != set.size())
            throw new IllegalArgumentException("같은 번호가 입력 되었습니다");
    }

    public static void moneyCheckException(int money) {
        if (money < LOTTO)
            throw new IllegalArgumentException("돈이 부족합니다.");
        if (money % LOTTO != ZERO) {
            throw new IllegalArgumentException("1000원 단위로 입력해 주세요");
        }
    }

    public static void checkBonusBallException(List<Integer> winningLotto, int bonusBall) {
        overException(bonusBall);
        List<Integer> plusBonus = new ArrayList<>(winningLotto);
        plusBonus.add(bonusBall);

        HashSet<Integer> set = new HashSet<>(plusBonus);
        if (plusBonus.size() != set.size())
            throw new IllegalArgumentException("같은 번호가 입력 되었습니다");
    }
}
