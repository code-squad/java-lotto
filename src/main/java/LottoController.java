import java.util.Collections;
import java.util.List;

public class LottoController {
    public static void main(String[] args){
        int budget = LottoInput.scanBudget();
        Lotto lotto = new Lotto(budget);
        LottoView.announceMyCards(lotto.getCards());
        List<Integer> result = lotto.getResult(LottoInput.scanLuckyNumber());
        LottoView.announceResult(result, budget);
    }
}
