package com.zingoworks.lotto.model.lotto.lottoPack;

import com.zingoworks.lotto.model.Money;
import com.zingoworks.lotto.model.Prize;
import com.zingoworks.lotto.model.lotto.Lotto;
import com.zingoworks.lotto.model.lotto.WinningLotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoPack {
    private List<Lotto> lottoPack = new ArrayList<>();
    private int amountOfManualLotto;
    private int amountOfAutoLotto;

    public LottoPack(Money money, List<String> manualLottoNumbers) {
        this.amountOfManualLotto = manualLottoNumbers.size();
        this.amountOfAutoLotto = money.amountToPurchase() - this.amountOfManualLotto;

        addLotto(new ManualLottoPack(manualLottoNumbers));
        addLotto(new AutoLottoPack());
    }

    public List<Lotto> getLottoPack() {
        return lottoPack;
    }

    public List<Prize> generateWinStatus(WinningLotto winningLotto) {
        List<Prize> wins = new ArrayList<>();
        for (Lotto lotto : lottoPack) {
            wins.add(lotto.getPrize(winningLotto));
        }
        wins.removeAll(Collections.singleton(null));
        return wins;
//        혹은
//        return wins.stream().filter(i -> i != null).collect(Collectors.toList());
    }

    public String getPurchasePhrase() {
        return "수동으로 " + amountOfManualLotto + "장, 자동으로 "
                + amountOfAutoLotto + "장을 구매했습니다.";
    }

    private void addLotto(LottoPackGenerator lottoPackGenerator) {
        lottoPack.addAll(lottoPackGenerator.generate(amountOfAutoLotto));
    }
}
