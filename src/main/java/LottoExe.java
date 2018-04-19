import domain.BuyLotto;
import domain.Lotto;
import domain.Rank;
import domain.WinningNum;
import view.Output;
import view.UserInput;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LottoExe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalPay = UserInput.purchasePrice(scanner);
        int manualLottoCount = UserInput.manualCount(scanner);
        List<String> manualLotto = UserInput.manualLottoNumbs(manualLottoCount);

        BuyLotto purchaseLotto = new BuyLotto(totalPay, manualLotto);
        List<Lotto> lottos = purchaseLotto.getLottos();

        Output.allLottoNum(manualLottoCount, lottos);

        String winningNum = UserInput.winningNumber(scanner);

        int bonusBall = UserInput.bonusBall(scanner);
        WinningNum preWinNum = new WinningNum(winningNum, bonusBall);

        Map<Rank, Integer> result = preWinNum.checkRank(lottos);

        Output.resultView(result);
    }
}
