package lottogame.domain;

import lottogame.dto.Result;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private List<Lotto> lottos;

    public LottoGame(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Result result(WinnningLotto winningNumber) {
        Map<PrizeRank, Integer> resultMap = initRewardAndHitCountMap();

        for (Lotto lotto : lottos) {
            PrizeRank reward = PrizeRank.find(
                    lotto.match(winningNumber.winningLotto),
                    lotto.isContain(winningNumber.bonusNumber));
            resultMap.put(reward, resultMap.get(reward) + 1);
        }

        return new Result(resultMap);
    }

    private Map<PrizeRank, Integer> initRewardAndHitCountMap() {
        Map<PrizeRank, Integer> map = new HashMap<>();
        for (PrizeRank value : PrizeRank.values()) {
            map.put(value, 0);
        }
        return map;
    }
}
