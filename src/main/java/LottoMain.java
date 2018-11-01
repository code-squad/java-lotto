import lotto.UserLotto;
import lotto.WinningLotto;
import util.Utility;
import view.InputView;
import view.PrintView;
import vo.Num;

public class LottoMain {
    public static void main(String[] args) {
        int lottoCount = InputView.inputPrice();
        PrintView.printLottoCount(lottoCount);

        UserLotto userLottos = new UserLotto(lottoCount);
        PrintView.printAutoLotto(userLottos.toDto());

        WinningLotto winningLotto = new WinningLotto(InputView.intputWinningNumber(),new Num(InputView.inputBonusBall()));

        PrintView.printResult(userLottos.matchNum(winningLotto),Utility.multiplyThousand(lottoCount));
    }
}
