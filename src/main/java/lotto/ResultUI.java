package lotto;

import java.util.Map;

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
        Map<Integer, Integer> result = lottoResult.getStatistics();
        for (Integer integer : result.keySet()) {
            System.out.println(integer+"개 일치 ("+PriceType.getPriceType(integer).getPrice()+") - "+result.get(integer)+"개" );
        }
    }

    public void printPercentage() {
        System.out.println("수익률은 "+lottoResult.getPercentage()+"% 입니다");
    }
    
}
