package lotto.domain;

import com.google.common.collect.Lists;
import lotto.Prize;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;
    private int purchaseAutomaticAmount;
    private int purchaseManualAmount;
    private List<LottoNumber> purchasedLottos;


    public LottoGame(int purchaseAmount, List<String> manualPurchaseOfNumbers) {
        this.purchaseAutomaticAmount = getPurchaseAutomaticAmount(purchaseAmount, LOTTO_PRICE * manualPurchaseOfNumbers.size());
        this.purchaseManualAmount = getPurchaseManualAmount(purchaseAmount, purchaseAutomaticAmount);
        this.purchasedLottos = Lists.newArrayList();
        this.purchasedLottos.addAll(generateManualLottoNumbers(manualPurchaseOfNumbers));
        this.purchasedLottos.addAll(generateAutomaticLottoNumbers(purchaseAutomaticAmount));
    }

    private List<LottoNumber> generateManualLottoNumbers(List<String> manualPurchaseOfNumbers) {
        return manualPurchaseOfNumbers.stream().map(this::split).map(LottoNumber::new).collect(Collectors.toList());
    }

    private List<LottoNumber> generateAutomaticLottoNumbers(int purchaseAutomaticAmount) {
        int purchaseCount = getPurchaseCount(purchaseAutomaticAmount);
        List<LottoNumber> lottoNumbers = Lists.newArrayList();

        for (int i = 0; i < purchaseCount; i++)
            lottoNumbers.add(createLottoNumber());
        return lottoNumbers;
    }

    public LottoGameResult play(List<Integer> winningNumber, int bonusNumber) {
        LottoNumber winningLottoNummber = new LottoNumber(winningNumber);
        BonusNumber bonusNumberMeta = new BonusNumber(bonusNumber);
        Map<Prize, Integer> calculatedResult = PrizeCalculator.calculate(purchasedLottos, winningLottoNummber, bonusNumberMeta);
        int calculateEarningRate = PrizeCalculator.calculateEarningRate(purchaseAutomaticAmount, calculatedResult);

        return new LottoGameResult(calculatedResult, calculateEarningRate);
    }

    static LottoNumber createLottoNumber() {
        return new LottoNumber();
    }

    public List<LottoNumber> getPurchasedLottos() {
        return this.purchasedLottos;
    }

    private int getPurchaseAutomaticAmount(int purchaseAmount, int purchaseManualAmount) {
        return purchaseAmount - purchaseManualAmount;
    }

    private int getPurchaseManualAmount(int purchaseAmount, int purchaseAutomaticAmount) {
        return purchaseAmount - purchaseAutomaticAmount;
    }

    private int getPurchaseCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    private List<Integer> split(String commaSeperatedLotto) {
        return Arrays.stream(commaSeperatedLotto.split(",", -1)).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
    }

    public int getPurchaseAutomaticCount() {
        return purchaseAutomaticAmount / LOTTO_PRICE;
    }

    public int getPurchaseManualCount() {
        return purchaseManualAmount / LOTTO_PRICE;
    }
}
