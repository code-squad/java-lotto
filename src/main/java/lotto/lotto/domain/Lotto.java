package lotto.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    private static final int NUMBER = 6;
    private List<Integer> lotto;

    public Lotto(String lottoNumbers) {
        String[] lottoNumber = Parse.escapeNum(lottoNumbers);
        notLottoException(lottoNumber);

        List<Integer> lotto = Parse.divideNum(lottoNumber);
        sameNumberException(lotto);
        this.lotto = lotto;
    }

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public static Lotto of(String lotto) {
        return new Lotto(lotto);
    }

    public static Lotto automaticLotto() {
        return new Lotto(LottoUtils.createLotto());
    }

    public Rank valueOfRank(WeeklyLotto weeklyLotto) {     //당첨번호와 비교한다.
        int collectNum = weeklyLotto.coutOfMatchLotto(lotto);
        boolean matchBonus = weeklyLotto.collectBonusBall(lotto);
        return Rank.valueOf(collectNum, matchBonus);
    }

    public void notLottoException(String[] numbers) {
        if (numbers.length != NUMBER)
            throw new IllegalArgumentException("당첨 번호가 잘못 입력 되었습니다");
    }

    public static void sameNumberException(List<Integer> winningLotto) {
        HashSet<Integer> set = new HashSet<>(winningLotto);
        if (winningLotto.size() != set.size())
            throw new IllegalArgumentException("같은 번호가 입력 되었습니다");
    }

    public List<Integer> getLotto() {
        return lotto;
    }
}