package domain;

import java.util.List;

public class LottoChecker {
    private final List<Integer> winningNums;

    public LottoChecker(List<Integer> winningNums) {
        this.winningNums = winningNums;
    }

    public int getStrikeNum(List<Integer> lotto) {
        int strikePoint = 0;
        for (Integer num : lotto) {
            strikePoint += strikeCheck(num);
        }
        return strikePoint;
    }

    int strikeCheck(Integer num) {
        if(winningNums.contains(num)) {
            return 1;
        }
        return 0;
    }
}
