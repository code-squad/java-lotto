package lottoGame.domain;

import lottoGame.dto.Result;
import lottoGame.util.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private int lottoNum;
    private List<Lotto> lottos = new ArrayList<>();
    private Result result = new Result();

    public LottoGame(int price) {
        this.lottoNum = LottoGenerator.lottoNum(price);

        for(int i=0; i<lottoNum; i++) {
            lottos.add(new Lotto(LottoGenerator.makeLotto()));
        }
    }

    public void runGame(List<Integer> lastWeekNums) {
        for (Lotto lotto : lottos) {
            lotto.matchPoint(lastWeekNums);
        }
        result.winnerResult(this.lottos);
    }


    public List<Lotto> getLottos() {
        return lottos;
    }

    public Result getResult() {
        return result;
    }

}
