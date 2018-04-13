package lotto.domain;

import lotto.Prize;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PrizeCalculator {

    public static Map<Prize, Integer> calculate(List<LottoNumber> lottoNumbers, LottoNumber lastPrizeOfNumbers, BonusNumber bonusNumber) {
        List<Prize> myPrize = lottoNumbers.stream()
                .map(lottoNumber -> Prize.findPrize(lottoNumber.getEqualCount(lastPrizeOfNumbers), bonusNumber.isMatchedBonusNumber(lottoNumber)))
                .collect(Collectors.toList());

        return PrizeResult.calculatePrizeResult(myPrize);
    }

    public static int calculateEarningRate(int payMoney, Map<Prize, Integer> prizeMap) {
        double summerizedEarningMoney = prizeMap.keySet().stream().filter(c -> prizeMap.get(c) > 0).mapToDouble(c->c.getMoney() * prizeMap.get(c)).sum();

        if (summerizedEarningMoney == 0) {
            return 0;
        }
        return (int) (summerizedEarningMoney / payMoney * 100);
    }
}
