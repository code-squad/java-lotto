package lotto;

import java.util.Map;

public class ResultUI {

    public static void printCount(LottoStore lottoStore) {
        System.out.println(lottoStore.getLottos().size()+"개를 구매했습니다.");
    }

    public static void printLottos(LottoStore lottoStore) {
        for (Lotto lotto : lottoStore.getLottos()) {
            printLotto(lotto);
        }
    }

    private static void printLotto(Lotto lotto) {
        System.out.println("["+lotto.joinNumbers()+"]");
    }
    
    public static void printStatistics(LottoResult lottoResult) {
        Map<Integer, Integer> result = lottoResult.getStatistics();
        for (Integer integer : result.keySet()) {
            System.out.println(integer+"개 일치 ("+PriceType.getPriceType(integer).getPrice()+") - "+result.get(integer)+"개" );
        }
    }

    public static void printPercentage(LottoResult lottoResult) {
        System.out.println("수익률은 "+lottoResult.getPercentage()+"% 입니다");
    }
    
}
