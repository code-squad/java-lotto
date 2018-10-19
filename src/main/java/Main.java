import domain.LottoGenerator;
import domain.Money;
import dto.WinResultDto;

import static view.ResultView.*;
import static view.InputView.*;

public class Main {

    public static void main(String[] args) {
        Money money = new Money(inputCash());

        LottoGenerator lottoGenerator = LottoGenerator.init(buyLotto(money.getLottoAmt()));
        printLottos(lottoGenerator.toLottoDtos());

        WinResultDto winResult = lottoGenerator.checkWins(getWinningLotto(), inputBonusNum());

        winStats(winResult);
        printYield(money.getYield(winResult));
    }

}
