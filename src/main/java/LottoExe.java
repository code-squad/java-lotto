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

        BuyLotto purchaseLotto = new BuyLotto(totalPay);
        List<Lotto> lottos = purchaseLotto.getLottos();

        Output.allLottoNum(lottos);

        String winningNum = UserInput.winningNumber(scanner);
        WinningNum preWinNum = new WinningNum(winningNum);

        Map<Rank, Integer> result = preWinNum.checkRank(lottos);

        Output.resultView(result);

    }
}
