package lotto.domain;

import lotto.Prize;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class PrizeCalculator {

    public static Map<Prize, Integer> calculate(List<LottoNumber> lottoNumbers, LottoNumber lastPrizeOfNumbers) {
        List<Prize> myPrize = lottoNumbers.stream()
                .map(lottoNumber -> Prize.findPrize(lottoNumber.getEqualCount(lastPrizeOfNumbers)))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return PrizeResult.calculatePrizeResult(myPrize);
    }

    public static int calculateEarningRate(int payMoney, Map<Prize, Integer> prizeMap) {
        int summerizedEarningMoney = prizeMap.keySet().stream().filter(c -> prizeMap.get(c) > 0).mapToInt(Prize::getMoney).sum();

        if (summerizedEarningMoney == 0) {
            return 0;
        }
        return summerizedEarningMoney / payMoney * 100;
    }
}
