import lotto.Lotto;
import lotto.UserLotto;
import lotto.WinningLotto;
import view.InputView;
import view.PrintView;
import vo.Num;

import java.util.TreeSet;

public class LottoMain {
    public static void main(String[] args) {
        int lottoCount = InputView.inputPrice();
        PrintView.printLottoCount(lottoCount);

        UserLotto userLottos = new UserLotto(lottoCount);
        PrintView.printAutoLotto(userLottos.toDto());

        Lotto lotto = new Lotto(InputView.intputWinningNumber());
    }
}
