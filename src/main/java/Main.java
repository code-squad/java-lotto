import domain.Lotto;
import domain.LottoGenerator;
import domain.No;
import domain.WinningLotto;
import dto.NoDto;

import static view.ResultView.*;
import static view.InputView.*;

public class Main {

    public static void main(String[] args) {
        int purchaseAmt = inputCash();

        LottoGenerator lottoGenerator = LottoGenerator.init(buyLotto(purchaseAmt));
        printLottos(lottoGenerator.toLottoDtos());

        winStats(lottoGenerator.checkWins(getWinningLotto(), inputBonusNum()), purchaseAmt);
    }

}
