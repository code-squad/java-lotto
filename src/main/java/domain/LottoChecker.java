package domain;

import java.util.List;

public class LottoChecker {
    private final List<Integer> winningNums;

    public LottoChecker(List<Integer> winningNums) {
        this.winningNums = winningNums;
    }

    public int getMatchNum(List<Integer> lotto) {
        int matchPoint = 0;
        for (Integer num : lotto) {
            matchPoint += matchCheck(num);
        }
        return matchPoint;
    }

    int matchCheck(Integer num) {
        if(winningNums.contains(num)) {
            return 1;
        }
        return 0;
    }
}
