package domain;

import java.util.List;

public class Lotto {
    private final int MAX_LOTTO_NUM = 6;
    private List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        if (lotto.size() != MAX_LOTTO_NUM) throw new IllegalArgumentException("잘 못 입력하였습니다.");
        this.lotto = lotto;
    }

    int countMatchedNumber(Lotto winningLotto) {
        int matchedNumberCnt = 0;
        for (int i = 0; i < MAX_LOTTO_NUM; i++) {
            if (winningLotto.isContains(this.lotto.get(i))) matchedNumberCnt++;
        }
        return matchedNumberCnt;
    }

    boolean checkBonusNumber(int bonus) {
        for (int i = 0; i < MAX_LOTTO_NUM; i++) {
            if (this.lotto.contains(bonus)) return true;
        }
        return false;
    }

    private boolean isContains(int number) {
        return this.lotto.contains(number);
    }

    @Override
    public String toString() {
        return "" + lotto;
    }
}
