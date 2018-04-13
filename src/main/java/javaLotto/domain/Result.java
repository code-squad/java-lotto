package javaLotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Result {

    private Rank rank;
    private int grade;
    private int winningMoney;
    private boolean bonus;

    public Result(Rank rank) {
        this.rank = rank;
        this.grade = rank.getCountOfMatch();
        this.winningMoney = rank.getWinningMoney();
        this.bonus = rank.isBonus();

    }

    public Rank getRank() {
        return rank;
    }

    public int getGrade() {
        return grade;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean isBonus() {
        return bonus;
    }

    public boolean match(int countOfMatch) {
        Map<Integer,Integer> map = new HashMap<>();
        if(this.grade == countOfMatch) return true;
        return false;
    }
}
