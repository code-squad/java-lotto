package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import lotto.util.LottoUtils;

import static lotto.view.Input.getCommonLottoNumbers;

public class LottoMachine {
    private int randomLottoCount;
    private int customLottoCount;

    public LottoMachine(int money, int customLottoCount) {
        this.randomLottoCount = money / LottoUtils.THOUSAND - customLottoCount;
        this.customLottoCount = customLottoCount;
    }

    public static LottoMachine init(int money, int customLottoCount) {
        return new LottoMachine(money, customLottoCount);
    }

    public Lottos generateLottos(List<Lotto> customLottos) {
        List<Lotto> lottos = new ArrayList<>();
        if(customLottos != null) { lottos.addAll(customLottos); }
        IntStream.range(0, randomLottoCount).forEach(i -> lottos.add(Lotto.newRandomLotto()));

        return Lottos.generate(lottos);
    }

    public static List<Lotto> makeCustomLottos(int customCount) {
        List<Lotto> lottos = new ArrayList<>();
        IntStream.range(0, customCount).forEach(i -> lottos.add(Lotto.newCustomLotto(getCommonLottoNumbers())));
        return lottos;
    }

    public int getRandomLottoCount() {
        return randomLottoCount;
    }

    public int getCustomLottoCount() {
        return customLottoCount;
    }
}
