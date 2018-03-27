package domain;

import domain.result.LottoResults;
import domain.result.Rank;
import domain.result.LottoResult;
import utils.LottoMachine;

import java.util.List;

public class LottoBundle {
    private List<Lotto> lottoBundle;

    public LottoBundle(int amount) {
        if (LottoMachine.isImPossibleBuy(amount)) {
            throw new IllegalArgumentException("돈이 부족하여 구매할 수 없습니다.");
        }
        lottoBundle = buyLotto(amount);
    }

    private static List<Lotto> buyLotto(int amount) {
        LottoMachine machine = LottoMachine.of();
        return machine.publishLotto(amount);
    }

   // TODO : 보너스 매칭해서 보너스에 따라 결과가 달라지도록 설정하기(근데 이건 매치포인트가 5일 때만 그래서, 따로 메소드 만드는게 좋을듯) 1,2,3,4,5,6, 9
    public LottoResults matchLotto(WinningLotto winningLotto) {
        LottoResults results = new LottoResults();
        for (Lotto lotto : lottoBundle) {
            int matchPoint = winningLotto.match(lotto);
            if (!Rank.isNotRank(matchPoint)) {
                results.addResult(new LottoResult(matchPoint));
            }
        }
        return results;
    }

    public String getPurchaseHistory() {
        StringBuilder builder = new StringBuilder();
        for (Lotto lotto : lottoBundle) {
            builder.append(lotto.toString());
            builder.append("\n");
        }
        return builder.toString();
    }
}
