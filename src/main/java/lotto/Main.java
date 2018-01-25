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
        int count = lottoMachine.countForPrice(money);

        //개수 출력
        showCount(count);

        //로또 구입
        lottoMachine.buyLottos(count);

        //구입한 로또 출력
        showLotto(lottoMachine.getLottos());

        //지난 주 당첨 번호 입력
        Lotto matchingNumbers = inputMatchingNumbers();

        //보너스 볼 입력
        int bonusNumber = inputBonusNumber();

        WinningLotto winningLotto = createWinningLotto(matchingNumbers, bonusNumber);

        //통계 조회
        Result result = lottoMachine.makeResult(winningLotto);

        showResult(result, money);
    }
}
