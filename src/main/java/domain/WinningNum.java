package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningNum {

    private static final int PREVIOUS_WINNER_NUMBER_LENGTH = 6;

    private List<Integer> preWinNums;
    private int bonusBall;

    public WinningNum(String preWinNum, int bonusBall) {
        preWinNums = Parser.parsing(preWinNum);
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
            Rank value = lotto.matchedLotto(this);
            putRank(numOfRank, value);
        }
        return numOfRank;
    }

    private void putRank(Map<Rank, Integer> numOfRank, Rank value) {
        if (value != null) {
            numOfRank.put(value, numOfRank.get(value) + 1);
        }
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
