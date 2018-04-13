package lotto;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private List<List<Integer>> match_six;

    private List<List<Integer>> match_five;

    private List<List<Integer>> match_four;

    private List<List<Integer>> match_three;

    public GameResult() {
        this.match_six = new ArrayList<>();
        this.match_five = new ArrayList<>();
        this.match_four = new ArrayList<>();
        this.match_three = new ArrayList<>();
    }

    public List<List<Integer>> getMatchSix() {
        return match_six;
    }

    public void addMatch_six(List<Integer> match_six) {
        this.match_six.add(match_six);
    }

    public void addMatch_five(List<Integer> match_five) {
        this.match_five.add(match_five);
    }

    public void addMatch_four(List<Integer> match_four) {
        this.match_four.add(match_four);
    }

    public void addMatch_three(List<Integer> match_three) {
        this.match_three.add(match_three);
    }

    public int getMatchSixCount() {
        return match_six.size();
    }

    public int getMatchFiveCount() {
        return match_five.size();
    }

    public int getMatchFourCount() {
        return match_four.size();
    }

    public int getMatchThreeCount() {
        return match_three.size();
    }

    public long getEarnedMoney() {
        long money = 0;

        if (match_six.size() > 0) {
            money += 2000000000 * match_six.size();
        }

        if (match_five.size() > 0) {
            money += 1500000 * match_five.size();
        }

        if (match_four.size() > 0) {
            money += 50000 * match_four.size();
        }

        if (match_three.size() > 0) {
            money += 5000 * match_three.size();
        }

        return money;
    }

}
