package lotto.domain;

import com.google.common.collect.Lists;
import lotto.Prize;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PrizeCalculator {

    private static List<PrizeEvaluator> prizeEvaluators = Lists.newArrayList(
            new PrizeEvaluator.First(),
            new PrizeEvaluator.Second(),
            new PrizeEvaluator.Third(),
            new PrizeEvaluator.Fourth()
    );

    public static Map<Prize, Integer> calculate(List<LottoNumber> lottoNumbers, LottoNumber lastPrizeOfNumbers) {
        List<Prize> myPrize = lottoNumbers.stream()
                .flatMap(lottoNumber -> prizeEvaluators.stream()
                        .filter(c -> c.isMatch(lottoNumber, lastPrizeOfNumbers))
                        .map(PrizeEvaluator::getCount)
                        .map(Prize::findPrize))
                .collect(Collectors.toList());

        return PrizeResult.calculatePrizeResult(myPrize);
    }

    public static int calculateEarningRate(int payMoney, Map<Prize, Integer> prizeMap) {
        int summerizedEarningMoney = prizeMap.keySet().stream().filter(c -> prizeMap.get(c) > 0).mapToInt(Prize::getMoney).sum();

        if (summerizedEarningMoney == 0) {
            return 0;
        }
        return payMoney / summerizedEarningMoney * 100;
    }
}
