package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private List<LottoNo> winningLottos;
    private int bonus;

    public WinningLotto(String winNumbers, int bonus) {
        this.winningLottos = Arrays.stream(winNumbers.split(",")).map(i -> new LottoNo(Integer.parseInt(i))).collect(Collectors.toList());
        if (winningLottos.size() != 6 || bonus == 0 ) {
            throw new IllegalArgumentException();
        }
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public List<LottoNo> getWinningLottos() {
        return winningLottos;
    }

    public Rank getResult(Lotto lotto) {
        return Rank.valueOf(getMatch(lotto).size(), lotto.getNumbers().contains(bonus));
    }

    private List<LottoNo> getMatch(Lotto lotto) {
        return lotto.getNumbers().stream().filter(number->this.winningLottos.contains(number)).collect(Collectors.toList());
    }
}
