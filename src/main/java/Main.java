import domain.LottoGenerator;
import domain.Money;
import dto.WinResultDto;

import static view.ResultView.*;
import static view.InputView.*;

public class Main {

    public static void main(String[] args) {
        Money money = new Money(inputCash());
        int lottoManualAmt = inputLottoManualAmt();

        LottoGenerator lottoGenerator = LottoGenerator.initAutoAndArtifitial(buyLottoManual(lottoManualAmt), money.getLottoAmt());
        printLottos(lottoGenerator.toLottoDtos(), lottoManualAmt);

        WinResultDto winResult = lottoGenerator.checkWins(getWinningLotto(), inputBonusNum());

        winStats(winResult);
        printYield(money.getYield(winResult));
    }

}
