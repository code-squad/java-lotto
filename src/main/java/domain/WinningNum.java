package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningNum {
    private List<Integer> preWinNums;
    private int bonusBall;

    public WinningNum(String preWinNum, int bonusBall) {
        String[] winNum = preWinNum.split(",");
        ExceptionCheck.numLengthCheck(winNum);
        preWinNums = new ArrayList<>();
        for (String winningNum : winNum) {
            preWinNums.add(Integer.parseInt(winningNum));
        }
        this.bonusBall = bonusBall;
    }

    public List<Integer> getPreWinNums() {
        return preWinNums;
    }

    private Map<Rank, Integer> initRank() {
        Map<Rank, Integer> numOfRank = new HashMap<>();
        for (Rank r : Rank.values()) {
            numOfRank.put(r, 0);
        }
        return numOfRank;
    }

    public Map<Rank, Integer> checkRank(List<Lotto> lottos) {
        Map<Rank, Integer> numOfRank = initRank();
        for (Lotto lotto : lottos) {
            Rank value = lotto.matchedLotto(this, bonusBall);
            putRank(numOfRank, value);
        }
        return numOfRank;
    }

    private void putRank(Map<Rank, Integer> numOfRank, Rank value) {
        if (value != null) {
            numOfRank.put(value, numOfRank.get(value) + 1);
        }
    }
}
