package domain;

import spark.utils.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        if (CollectionUtils.isEmpty(lottos)) {
            throw new IllegalArgumentException();
        }
        this.lottos = lottos;
    }

    public Lottos(Lottos... lottos) {
        this(getLottoFromLottos(lottos));
    }

    public int size() {
        return lottos.size();
    }

    public WinningLottos match(WinningNumbers winningNumbers) {
        if (winningNumbers == null) {
            throw new IllegalArgumentException();
        }
        return new WinningLottos(matchLottos(winningNumbers));
    }

    private static List<Lotto> getLottoFromLottos(Lottos[] lottos) {
        return Arrays.stream(lottos)
                     .filter(Objects::nonNull)
                     .flatMap(lotto -> lotto.lottos.stream())
                     .collect(Collectors.toList());
    }

    private List<WinningLotto> matchLottos(WinningNumbers winningNumbers) {
        return lottos.stream()
                     .map(lotto -> lotto.match(winningNumbers))
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
