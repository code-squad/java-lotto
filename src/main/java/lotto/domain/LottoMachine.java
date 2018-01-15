package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import lotto.domain.generator.RandomLottoNumberGenerator;
import lotto.util.LottoUtils;

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
        IntStream.range(0, lottoCount).forEach(i -> lottos.add(Lotto.generate(new RandomLottoNumberGenerator())));

        return lottos;
    }

}
