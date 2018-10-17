package lottogame.domain;

import lottogame.util.NumberGenerator;
import lottogame.dto.ResultDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private List<Lotto> lottos;

    public LottoGame(int money, NumberGenerator numberGenerator) {
        lottos = new ArrayList<>();
        for (int i = 0; i < money / LOTTO_PRICE; i++) {
            lottos.add(new Lotto(numberGenerator.generate()));
        }
    }

    public int countLotto() {
        return lottos.size();
    }

    public ResultDTO result(WinnningLotto winningNumber) {
        Map<PrizeRank, Integer> map = getRewardAndHitCountMap();

        for (Lotto lotto : lottos) {
            PrizeRank reward = PrizeRank.find(lotto.match(winningNumber.winningLotto),
                    lotto.isContain(winningNumber.bonusNumber));
            map.put(reward, map.get(reward) + 1);
        }

        map.remove(PrizeRank.BOOM);
        return new ResultDTO(map);
    }

    private Map<PrizeRank, Integer> getRewardAndHitCountMap() {
        Map<PrizeRank, Integer> map = new HashMap<>();
        for (PrizeRank value : PrizeRank.values()) {
            map.put(value, 0);
        }
        return map;
    }

    public Stream<Lotto> readLotto() {
        return lottos.stream();
    }
}
