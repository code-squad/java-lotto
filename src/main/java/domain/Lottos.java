package domain;

import java.util.List;

public class Lottos {
    private List<Lotto> Lottos;
    private LottoryManager lottoryManager;

    private Lottos(List<Lotto> lottos, int input) {
        this.Lottos = lottos;
        this.lottoryManager = LottoryManager.of(input);
    }

    public static Lottos of(List<Lotto> lottos, int input) {
        return new Lottos(lottos, input);
    }

    public void matchLotto(WinnerLotto winnerLotto) {
        for (Lotto lotto : this.Lottos) {
            lottoryManager.increase(winnerLotto.compareLotto(lotto), winnerLotto.compareBonus(lotto));
        }
    }

    public List<Lotto> getLottos() {
        return Lottos;
    }

    public LottoryManager getLottoryManager() {
        return lottoryManager;
    }
}
