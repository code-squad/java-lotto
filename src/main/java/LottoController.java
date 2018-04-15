import java.util.Collections;
import java.util.List;

public class LottoController {
    public static void main(String[] args){
        Lotto lotto = new Lotto(LottoInput.scanBudget());
        LottoView.cards(lotto.getCards());
        LottoResult result = lotto.sendLuckyCard(LottoInput.scanLuckyNumber());
        LottoView.announce(result);
    }
}
