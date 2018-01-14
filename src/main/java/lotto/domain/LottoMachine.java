package lotto.domain;

import lotto.dto.LottoResult;
import lotto.util.LottoUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private int lottoCount;

    public LottoMachine(int money) {
        lottoCount = money / LottoUtils.THOUSAND;
    }

    public static LottoMachine init(int money) {
        return new LottoMachine(money);
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> generateLottos() {
        List<Lotto> lottos = new ArrayList<>();
        IntStream.range(0, lottoCount).forEach(i -> lottos.add(Lotto.generate(new LottoNumberGeneratorImpl())));

        return lottos;
    }

    public static List<LottoResult> getLottoResults(List<Lotto> lottos, List<Integer> winNumbers) {
        return lottos.stream()
                .map(lotto -> new LottoResult(lotto.getCorrectCount(winNumbers)))
                .collect(Collectors.toList());
    }

}
