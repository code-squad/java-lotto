package lottogame.dto;

import lottogame.domain.Lotto;
import lottogame.domain.WinnningLotto;
import lottogame.view.Money;

import java.util.Collections;
import java.util.List;

public class InputDto {
    private final Money money;
    private final List<Lotto> lottos;
    private final WinnningLotto winningLotto;

    public InputDto(Money money, List<Lotto> lottos, WinnningLotto winningLotto) {
        this.money = money;
        this.lottos = Collections.unmodifiableList(lottos);
        this.winningLotto = winningLotto;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public WinnningLotto getWinningLotto() {
        return winningLotto;
    }

    public int readMoney() {
        return money.value();
    }
}
