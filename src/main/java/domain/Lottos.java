package domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getNumOfLottos() {
        return lottos.size();
    }

    public WinningLottos getWinningLottos(WinningNumber winningNumber) {
        WinningLottos winningLottos = new WinningLottos();

        for(Lotto lotto : lottos)
            winningLottos.addLotto(winningNumber.matchLottoAndGetPrize(lotto));

        return winningLottos;
    }

    public Lottos join(Lottos lottos) {
        List<Lotto> newLottos = new ArrayList<>(this.getNumOfLottos() + lottos.getNumOfLottos());

        newLottos.addAll(this.lottos);
        newLottos.addAll(lottos.lottos);

        return new Lottos(newLottos);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Lotto lotto : lottos)
            sb.append(lotto.toString()).append('\n');
        return sb.toString();
    }
}
