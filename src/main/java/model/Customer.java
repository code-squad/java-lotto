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
        Map<Lotto, Rank> lottoWithRank = new HashMap();
        WinningLotto winningLotto = getWinningLotto(lottoNumber, bonusNum);

        for (Lotto lotto : lottos) {
            lottoWithRank.put(lotto, winningLotto.compare(lotto));
        }

        return match(winningLotto, lottoWithRank);
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

    private LottoResult match(WinningLotto winningLotto, Map<Lotto, Rank> lottoRankMap){
        return winningLotto.match(lottos, lottoRankMap);
    }
}
