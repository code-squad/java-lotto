package lottoGame.domain;

import lottoGame.dto.Result;
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

    public List<Lotto> runGame(Lotto lastWeekLotto) {
        for (Lotto lotto : lottos) {
            lotto.matchPoint(lastWeekLotto);
        }
        return lottos;
    }

    public int calcProfit(){
        return (Result.getAllProfit() / (lottos.size() * LottoGenerator.LOTTO_PRICE)) * 100;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
