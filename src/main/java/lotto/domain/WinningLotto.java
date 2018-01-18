package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private List<Integer> winningLottos;
    private int bonus;

    public WinningLotto(String winNumbers, int bonus) {
        this.winningLottos = Arrays.stream(winNumbers.split(",")).map(i -> Integer.parseInt(i)).collect(Collectors.toList());
        if (winningLottos.size() != 6 || bonus == 0 ) {
            throw new IllegalArgumentException();
        }
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public List<Integer> getWinningLottos() {
        return winningLottos;
    }

    public Rank getResult(Lotto lotto) {
        return Rank.valueOf(getMatch(lotto).size(), lotto.getNumbers().contains(bonus));
    }

    private List<Integer> getMatch(Lotto lotto) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : lotto.getNumbers()) {
            if (this.winningLottos.contains(number)) {
                result.add(number);
            }
        }
        return result;
    }
}
