package model;

import dto.LottoResult;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Customer {
    private static final Integer LOTTO_PRICE = 1000;

    private List<Lotto> lottos = new ArrayList();

    public List<Lotto> buy(Integer amount) {
        Integer number = amount / LOTTO_PRICE;

        for (int i = 0; i < number; i++) {
            lottos.add(new Lotto(RandomNumber.shuffleNumber()));
        }

        return lottos;
    }

    public LottoResult getLottoResult(String lottoNumber, Integer bonusNum) {
        Map<Rank, Integer> lottoWithRank = initResults();
        WinningLotto winningLotto = getWinningLotto(lottoNumber, bonusNum);

        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.compare(lotto);
            if (rank != null) {
                lottoWithRank.put(rank, lottoWithRank.get(rank) + 1);
            }
        }

        return new LottoResult(LottoMapStrategy.sortMap(lottoWithRank));
    }

    private Map<Rank, Integer> initResults() {
        Map<Rank, Integer> lottoWithRank = new HashMap<>();

        for (Rank rank: Rank.values()){
            lottoWithRank.put(rank, 0);
        }
        return lottoWithRank;
    }

    private WinningLotto getWinningLotto(String result, Integer bonusNum) {
        List<Integer> resultNumbers = new ArrayList();
        for (String value : result.split(",")) {
            resultNumbers.add(Integer.parseInt(value));
        }

        Lotto lotto = new Lotto(resultNumbers);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNum);

        return winningLotto;
    }
}
