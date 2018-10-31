package com.zingoworks.lotto.model.lotto.lottoPack;

import com.zingoworks.lotto.model.lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoPack implements LottoPackGenerator {
    private List<String> givenManualLottoPack;

    ManualLottoPack(List<String> givenManualLottoPack) {
        this.givenManualLottoPack = givenManualLottoPack;
    }

    @Override
    public List<Lotto> generate(int count) {
        List<Lotto> manualLottoPack = new ArrayList<>();
        for (String manualLotto : givenManualLottoPack) {
            manualLottoPack.add(Lotto.of(manualLotto));
        }
        return manualLottoPack;
    }
}
