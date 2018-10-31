import lotto.Lotto;
import lotto.Reward;
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

        WinningLotto winningLotto = new WinningLotto(InputView.intputWinningNumber());
        Num bonusNum = winningLotto.BonusCheck(new Num(InputView.inputBonusBall()));
        Lotto winningNumber = winningLotto.makeWinningLotto();

        PrintView.printResult(userLottos.matchNum(winningNumber,bonusNum),Utility.multiplyThousand(lottoCount));
    }
}
