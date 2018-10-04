package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputLottoWebView {

    public static String printNumberOfLottoPurchase(LottoGame lottoGame) {
        return intToString(lottoGame.getTotalCount());
    }

    private static String intToString(int value) {
        return String.valueOf(value);
    }

    public static List<String> printPurchaseLotto(LottoGame lottoGame) {
        List<String> totalLottoNumbers = new ArrayList<>();
        int totalPurchasedLottoCount = lottoGame.getTotalCount();
        for (int i = 0; i < totalPurchasedLottoCount; i++) {
            totalLottoNumbers.add(lottoGame.getUserLottoNumber(i));
        }

        return totalLottoNumbers;
    }

    public static Map<String, Object> winStat(LottoGameResult lottoGameResult, Money money) {
        Map<String, Object> model = new HashMap<>();
        model.put("fifth", lottoGameResult.getFifthPrizeCount());
        model.put("fourth", lottoGameResult.getFourthPrizeCount());
        model.put("third", lottoGameResult.getThirdPrizeCount());
        model.put("second", lottoGameResult.getSecondPrizeCount());
        model.put("first", lottoGameResult.getFirstPrizeCount());
        model.put("yield", lottoGameResult.getYield(money));

        return model;
    }

}