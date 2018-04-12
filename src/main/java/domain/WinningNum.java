package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WinningNum {
    private List<Integer> preWinNums;

    public WinningNum(String preWinNum) {
        String[] winNum = preWinNum.split(",");
        ExceptionCheck.numLengthCheck(winNum);
        preWinNums = new ArrayList<>();
        for (String winningNum : winNum) {
            preWinNums.add(Integer.parseInt(winningNum));
        }
    }

    public List<Integer> getPreWinNums() {
        return preWinNums;
    }

    private HashMap<Rank, Integer> initRank() {
        HashMap<Rank, Integer> numOfRank = new HashMap<>();
        for (Rank r : Rank.values()) {
            numOfRank.put(r, 0);
        }
        return numOfRank;
    }

    public HashMap<Rank, Integer> checkRank(List<Lotto> lottos) {
        HashMap<Rank, Integer> numOfRank = initRank();
        for (Lotto lotto : lottos) {
            Rank value = lotto.matchedLotto(this);
            putRank(numOfRank, value);
        }
        return numOfRank;
    }

    private void putRank(HashMap<Rank, Integer> numOfRank, Rank value) {
        if (value != null) {
            numOfRank.put(value, numOfRank.get(value) + 1);
        }
    }
}
