package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        if (lottos.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public WinningLottos match(WinningNumbers winningNumbers) {
        if (winningNumbers == null) {
            throw new IllegalArgumentException();
        }
        return new WinningLottos(getWinningLottos(winningNumbers));
    }

    private List<WinningLotto> getWinningLottos(WinningNumbers winningNumbers) {
        return lottos.stream()
                     .map(lotto -> lotto.getWinResult(winningNumbers))
                     .collect(Collectors.toList());
    }

    private List<String> convertLottoToString() {
        return lottos.stream()
                     .map(Lotto::toString)
                     .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return String.join("\n", convertLottoToString());
    }
}
