package lotto;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static lotto.InputView.*;
import static lotto.ResultView.*;
import static lotto.WinningLotto.createWinningLotto;

/**
 * Created by Joeylee on 2018-01-13.
 */
public class Main {

    public static void main(String[] args) {

        LottoMachine lottoMachine = new LottoMachine();
        Money money = getMoney();

        //수동 입력 및 구매 번호 선택
        List<Lotto> selfLottos = selfPurchaseCount();

        int autoCount = lottoMachine.countForPriceExceptSelfCount(money, selfLottos);

        //개수 출력
        showPurchaseCount(selfLottos.size(), autoCount);

        //로또 구입
        lottoMachine.buyLottos(autoCount);

        //구입한 로또 출력
        showLotto(lottoMachine.getLottos());

        //지난 주 당첨 번호 입력
        Lotto matchingNumbers = inputMatchingNumbers();

        //보너스 볼 입력
        LottoNo bonusNumber = inputBonusNumber();

        WinningLotto winningLotto = createWinningLotto(matchingNumbers, bonusNumber);

        //통계 조회
        Result result = lottoMachine.makeResult(winningLotto);

        showResult(result, money);
    }
}
