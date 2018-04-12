package Lotto;

import java.util.*;

public class Lotto {

    private static final int THREE_MATCH_MONEY = 5000;
    private static final int FOUR_MATCH_MONEY = 50000;
    private static final int FIVE_MATCH_MONEY = 1500000;
    private static final int SIX_MATCH_MONEY = 2000000000;

    private int threeMatchCount = 0;
    private int fourMatchCount = 0;
    private int fiveMatchCount = 0;
    private int sixMatchCount = 0;

    private int money;

    private List<Integer[]> lottoNumbers;
    private List<String> winnerNumber;

    public Lotto() {
        lottoNumbers = new ArrayList<>();
        winnerNumber = new ArrayList<>();
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setLottoNumbers(Integer[] lottoNumber) {
        this.lottoNumbers.add(lottoNumber);
    }

    public List<Integer[]> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public void setWinnerNumber(List<String> winnerNumber) {
        this.winnerNumber = winnerNumber;
    }

    public List<String> getWinnerNumber() {
        return this.winnerNumber;
    }

    public void setMatchCount(int matchCount) {
        if (matchCount == 3) {
            threeMatchCount++;
        } else if (matchCount == 4) {
            fourMatchCount++;
        } else if (matchCount == 5) {
            fiveMatchCount++;
        } else if (matchCount == 6) {
            sixMatchCount++;
        }
    }

    public int getThreeMatchCount() {
        return threeMatchCount;
    }

    public int getFourMatchCount() {
        return fourMatchCount;
    }

    public int getFiveMatchCount() {
        return fiveMatchCount;
    }

    public int getSixMatchCount() {
        return sixMatchCount;
    }

    public int getYield() {
        return Math.round(totalYieldMoney() / money * 100);
    }

    private float totalYieldMoney() {
        return THREE_MATCH_MONEY * threeMatchCount + FOUR_MATCH_MONEY * fourMatchCount + FIVE_MATCH_MONEY * fiveMatchCount + SIX_MATCH_MONEY * sixMatchCount;
    }
}
