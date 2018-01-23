package lottoGame.domain;

import lottoGame.enums.Rank;
import lottoGame.util.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private int lottoNum;
    private List<Lotto> lottos = new ArrayList<>();

    public LottoGame(int price,List<Lotto> lottos) {
        this.lottoNum = LottoGenerator.lottoNum(price);

        this.lottos = lottos;
    }

    public List<Lotto> runGame(WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            lotto.matchPoint(winningLotto);
        }
        return lottos;
    }

    public int getRankCount(Rank rank) {
       return (int) this.lottos.stream()
                .filter(lotto -> lotto.lottoRank().equals(rank))
                .count();
    }

    public int calcProfit(){
        int profit = 0;
        for (Lotto lotto : lottos) {
            profit += lotto.lottoRank().getWinningMoney();
        }

        return (profit / (lottos.size() * LottoGenerator.LOTTO_PRICE)) * 100;
        /*return (Result.getAllProfit() / (lottos.size() * LottoGenerator.LOTTO_PRICE)) * 100;*/
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
