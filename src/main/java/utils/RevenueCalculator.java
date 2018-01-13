package utils;

import dto.LottoResult;
import spark.utils.CollectionUtils;

import java.util.List;

import static common.Constant.LOTTO_PRICE;

public class RevenueCalculator {

    public static double calculate(List<LottoResult> results) {
        if (CollectionUtils.isEmpty(results)) {
            throw new IllegalArgumentException();
        }
        return sumOfWinningMoney(results) / (double) getPurchaseAmount(results) * 100;
    }

    private static int getPurchaseAmount(List<LottoResult> results) {
        return results.size() * LOTTO_PRICE;
    }

    private static double sumOfWinningMoney(List<LottoResult> results) {
        return results.stream()
                      .mapToDouble(LottoResult::getWinningMoney)
                      .sum();
    }

}
