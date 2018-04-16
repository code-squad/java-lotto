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
        String[] winNum = preWinNum.split(",");
        numLengthCheck(winNum);
        preWinNums = new ArrayList<>();
        for (String winningNum : winNum) {
            preWinNums.add(Integer.parseInt(winningNum));
        }
        this.bonusBall = bonusBall;
    }

    private void numLengthCheck(String[] previousWinNum) {
        if (previousWinNum.length != PREVIOUS_WINNER_NUMBER_LENGTH) {
            throw new IllegalArgumentException("지난 주 당첨 번호는 숫자 6개입니다.");
        }
    }

    /*
    public Rank matchCount(List<Integer> lotto) {
        int matchCount = lotto.matchCount(preWinNums);
        boolean matchBonus = lotto.matchBonus(bonusBall);
        return Rank.valueOf(matchCount, matchBonus);
    }
    */


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
