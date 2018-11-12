package domain;

import java.util.List;

public class Lottos {
    private List<Lotto> Lottos;
    private LottoryManager lottoryManager;

    private Lottos(List<Lotto> lottos, Money money) {
        this.Lottos = lottos;
        this.lottoryManager = LottoryManager.of(money);
    }

    public static Lottos of(List<Lotto> lottos, Money money) {
        return new Lottos(lottos, money);
    }

    public static Lottos ofString(List<String> manualNumbers, String input) {
        int money = Integer.parseInt(input);
        List<Lotto> lottos = LottoFactory.of(manualNumbers, money / 1_000).getLottos();
        return new Lottos(lottos, Money.of(money));
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
