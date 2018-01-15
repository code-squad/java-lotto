package domain;


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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Lotto lotto : lottos)
            sb.append(lotto.toString()).append('\n');
        return sb.toString();
    }
}
