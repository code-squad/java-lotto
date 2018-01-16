package lotto.view;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoStore;
import lotto.domain.PriceType;

public class ResultUI {

    private LottoStore lottoStore;
    
    private LottoResult lottoResult;

    public ResultUI(LottoStore result) {
        this.lottoStore = result;

    }

    public void setLottoResult(LottoResult lottoResult) {
        this.lottoResult = lottoResult;
    }

    public void printCount() {
        System.out.println(this.lottoStore.getLottos().size()+"개를 구매했습니다.");
    }

    public void printLottos() {
        for (Lotto lotto : lottoStore.getLottos()) {
            printLotto(lotto);
        }
    }

    private void printLotto(Lotto lotto) {
        System.out.println("["+lotto.joinNumbers()+"]");
    }
    
    public void printStatistics() {
        Map<PriceType, Integer> result = lottoResult.getStatistics();
        for (PriceType priceType : result.keySet()) {
            System.out.println(priceType.getCount()+"개 일치 ("+ priceType.getPrice()+") - "+result.get(priceType)+"개" );
        }
    }

    public void printPercentage() {
        System.out.println("수익률은 "+lottoResult.getPercentage()+"% 입니다");
    }
    
}
