package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private List<Lotto> firstRank;

    private List<Lotto> secondRank;

    private List<Lotto> thirdRank;

    private List<Lotto> fourthRank;

    private List<Lotto> fifthRank;

    private List<Lotto> miss;

    public GameResult() {
        this.firstRank = new ArrayList<>();
        this.secondRank = new ArrayList<>();
        this.thirdRank = new ArrayList<>();
        this.fourthRank = new ArrayList<>();
        this.fifthRank = new ArrayList<>();
        this.miss = new ArrayList<>();
    }

    public void addFirstRank(Lotto lotto) {
        this.firstRank.add(lotto);
    }

    public void addSecondRank(Lotto lotto) {
        this.secondRank.add(lotto);
    }

    public void addThirdRank(Lotto lotto) {
        this.thirdRank.add(lotto);
    }

    public void addFourthRank(Lotto lotto) {
        this.fourthRank.add(lotto);
    }

    public void addFifthRank(Lotto lotto) {
        this.fifthRank.add(lotto);
    }

    public void addMiss(Lotto lotto) {
        this.miss.add(lotto);
    }

    public int getFirstRank() {
        return firstRank.size();
    }

    public int getSecondRank() {
        return secondRank.size();
    }

    public int getThirdRank() {
        return thirdRank.size();
    }

    public int getFourthRank() {
        return fourthRank.size();
    }

    public int getFifthRank() {
        return fifthRank.size();
    }

    public int getMissRank() {
        return miss.size();
    }

    public long getEarnedMoney() {
        long money = 0;

        if (firstRank.size() > 0) {
            money += 2000000000 * firstRank.size();
        }

        if (thirdRank.size() > 0) {
            money += 1500000 * thirdRank.size();
        }

        if (fourthRank.size() > 0) {
            money += 50000 * fourthRank.size();
        }

        if (fifthRank.size() > 0) {
            money += 5000 * fifthRank.size();
        }

        return money;
    }

}
