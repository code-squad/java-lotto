package com.zingoworks.lotto.domain;

import com.zingoworks.lotto.exception.SizeOutOfBoundsException;

import java.util.ArrayList;
import java.util.List;

public class Lottos implements LottosGenerator {
    private static final int PRICE_OF_LOTTO = 1000;

    private List<Lotto> lottos = new ArrayList<>();
    private int numberOfLottos;
    private int manualLottoAmounts;

    public Lottos(int purchaseAmount, List<String> manualLottoNumbers) {
        checkMinimumAmountOfMoney(purchaseAmount);
        this.numberOfLottos = purchaseAmount / PRICE_OF_LOTTO;
        this.manualLottoAmounts = manualLottoNumbers.size();
        checkCountOfManualLotto(manualLottoAmounts);

        addManualLottos(manualLottoNumbers);
        addAutomaticLottos();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }


//    이 미션의 가장 핵심 메소드는 이 메소드이다.
//    이 메소드가 테스트 가능하도록 설계를 개선해 본다.
//    설계를 개선하고 단위 테스트를 추가한다.
    public LottoResult match(WinningLotto winningLotto) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : lottos) {
            Prize prize = winningLotto.match(lotto);
            result.addPrize(prize);
        }
        return result;
    }

    private void addManualLottos(List<String> manualLottoNumbers) {
        for (String number : manualLottoNumbers) {
            lottos.add(new ManualLotto(number));
        }
    }

    private void addAutomaticLottos() {
        int automaticLottoAmounts = numberOfLottos - lottos.size();
        for (int i = 0; i < automaticLottoAmounts; i++) {
            lottos.add(new AutomaticLotto());
        }
    }

    public String getPurchasePhrase() {
        return "수동으로 " + manualLottoAmounts + "장, 자동으로 "
                + (numberOfLottos - manualLottoAmounts) + "장을 구매했습니다.";
    }

    private void checkMinimumAmountOfMoney(int amount) {
        if (amount < PRICE_OF_LOTTO) {
            throw new IllegalArgumentException("최소 구매금액은 1000원 이상입니다.");
        }
    }

    private void checkCountOfManualLotto(int numberOfManualLottos) {
        if (numberOfManualLottos < 0 || numberOfManualLottos > numberOfLottos) {
            throw new SizeOutOfBoundsException("유효한 개수가 아닙니다.");
        }
    }

    @Override
    public List<Lotto> generate(Money money) {
        return null;
    }
}
