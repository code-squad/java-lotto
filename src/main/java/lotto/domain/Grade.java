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

    public List<Lotto> getRandomLotto() {
        return randomLotto;
    }

    public List<Lotto> getManualLotto() {
        return manualLotto;
    }

    public List<Integer> getPrize() {
        return prize;
    }

    public int getBonus() {
        return bonus;
    }
}
