package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public class LottoMain {
    public static Map<Integer, Integer> map = new HashMap<>();
    static {
        map.put(0, 0);
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        map.put(6, 0);
    }

    public static void main(String[] args) {
        int myMoney = InputView.buyLotto();
        LottoManager lottos = null;
        Lotto winLotto = null;
        try {
            lottos = buyLotto(myMoney);
            winLotto = winLotto(lottos);
        } catch (InputMismatchException ime) { // 타입 에러
            System.out.println("정수만 입력 가능합니다.");
            main(args);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            main(args);
        }
        ResultView.winList(myMoney);
    }

    private static LottoManager buyLotto(int myMoney) {
        LottoManager lottos = new LottoManager(myMoney);
        ResultView.printLotto(lottos.toDto());
        return lottos;
    }

    private static Lotto winLotto(LottoManager lottos) {
        Lotto winLotto = null;
        try {
            winLotto = Lotto.ofWinLotto(InputView.lastWeekWinNumber());
            System.out.println(winLotto);
            for (int i = 0; i < lottos.getSize(); i++) {
                map.put(winLotto.obtainMatchCount(lottos.getLotto(i)), map.get(winLotto.obtainMatchCount(lottos.getLotto(i))) + 1);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            winLotto(lottos);
        }
        return winLotto;
    }
}
