package lotto.domain;

import java.util.List;

public class Grade {
    private List<Lotto> randomLotto;
    private List<Lotto> manualLotto;
    private List<Integer> prize;
    private int bonus;

    public Grade(List<Lotto> randomLotto, List<Lotto> manualLotto, List<Integer> prize, int bonus) {
        this.randomLotto = randomLotto;
        this.manualLotto = manualLotto;
        this.prize = prize;
        this.bonus = bonus;
    }

    public int getGrade(int winnerMoneyList) {
        int grade =0;
        for (int j = 0; j < randomLotto.size(); j++) {
            if (randomLotto.get(j).winnerMoney(prize, bonus) == winnerMoneyList) {
                grade++;
            }
        }
        return grade;
    }

    public int getManualGrade(int winnerMoneyList) {
        int grade =0;
        for (int j = 0; j < manualLotto.size(); j++) {
            if (manualLotto.get(j).winnerMoney(prize, bonus) == winnerMoneyList) {
                grade++;
            }
        }
        return grade;
    }
}
