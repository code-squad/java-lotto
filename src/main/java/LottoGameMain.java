import domain.LottoGame;
import dto.LottoResult;
import dto.UserLotto;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Scanner;

public class LottoGameMain {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int totalCount = LottoGame.amountOfLotto(InputView.inputMoney(sc));
        List<String> userLottoText = InputView.inputManualLottoNumber(sc, InputView.inputManualLottoCount(sc));

        LottoGame lottoGame = new LottoGame();
        lottoGame.getManualLottos(userLottoText);
        UserLotto userLotto = new UserLotto(lottoGame.getAutoLottos(totalCount), totalCount, userLottoText.size());
        OutputView.printMyLotto(userLotto);

        String luckyNumbers = InputView.inputLuckyNumbers(sc);
        int bonusNumber = InputView.inputBonusNumber(sc);

        LottoResult result = lottoGame.match(luckyNumbers, bonusNumber);
        OutputView.printCountOfWinLotto(result);
    }
}
