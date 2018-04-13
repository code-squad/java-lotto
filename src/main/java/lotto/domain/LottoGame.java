package lotto.domain;

import com.google.common.collect.Lists;
import lotto.Prize;

import java.util.List;
import java.util.Map;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;
    private int purchaseAmount;
    private List<LottoNumber> purchasedLottos;


    public LottoGame(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.purchasedLottos = generateLottoNumbers();
    }

    private List<LottoNumber> generateLottoNumbers() {
        int purchaseCount = purchaseAmount / LOTTO_PRICE;
        List<LottoNumber> lottoNumbers = Lists.newArrayList();

        for (int i = 0; i < purchaseCount; i++)
            lottoNumbers.add(createLottoNumber());
        return lottoNumbers;
    }

    public LottoGameResult play(List<Integer> winningNumber, int bonusNumber) {
        LottoNumber winningLottoNummber = new LottoNumber(winningNumber);
        BonusNumber bonusNumberMeta = new BonusNumber(bonusNumber);
        Map<Prize, Integer> calculatedResult = PrizeCalculator.calculate(purchasedLottos, winningLottoNummber, bonusNumberMeta);
        int calculateEarningRate = PrizeCalculator.calculateEarningRate(purchaseAmount, calculatedResult);

        return new LottoGameResult(calculatedResult, calculateEarningRate);
    }

    static LottoNumber createLottoNumber() {
        return new LottoNumber();
    }

    public List<LottoNumber> getPurchasedLottos() {
        return this.purchasedLottos;
    }

    public int getSize() {
        return this.purchasedLottos.size();
    }
}
