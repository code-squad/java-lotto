package domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        lotto.numbersCheck();
        lottos.add(lotto);
    }

    public void addLottos(Lottos lottos) {
        this.lottos.addAll(lottos.lottos);
    }

    public List<Rank> match(WinningLotto winningLotto) {
        List<Rank> ranks = new ArrayList<>();
        lottos.stream()
                .forEach(lotto -> checkRankRange(lotto, winningLotto, ranks));

        return ranks;
    }

    private void checkRankRange(Lotto lotto, WinningLotto numbers, List<Rank> ranks) {
        try {
            ranks.add(numbers.checkTheWinningNumbers(lotto));
        } catch (IllegalArgumentException iae) {
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(lottos.size());
        sb.append("개를 구매했습니다.\n");
        for (Lotto lotto : lottos) {
            sb.append(lotto);
            sb.append("\n");
        }
        return sb.toString();
    }
}
