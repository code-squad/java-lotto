import domain.Lotto;
import domain.LottoGenerator;
import domain.Money;
import domain.WinningLotto;
import dto.LottoDtos;
import dto.WinResultDto;

import static view.ResultView.*;
import static view.InputView.*;

public class Main {

    public static void main(String[] args) {
        Money money = new Money(inputCash());
        int lottoManualAmt = inputLottoManualAmt();

        LottoGenerator lottoGenerator = initLottoGenerator(lottoManualAmt, money.getLottoAmt());
        printLottos(lottoGenerator.toLottoDtos(), lottoManualAmt);

        WinResultDto winResult = initWinResultDto(lottoGenerator.toLottoDtos());

        winStats(winResult);
        printYield(money.getYield(winResult));
    }

    public static LottoGenerator initLottoGenerator(int lottoManualAmt, int lottoAmt) {
        LottoGenerator lottoGenerator = null;
        try {
            lottoGenerator = LottoGenerator.initAutoAndArtifitial(buyLottoManual(lottoManualAmt), lottoAmt);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return initLottoGenerator(lottoManualAmt, lottoAmt);
        }
        return lottoGenerator;
    }

    public static WinResultDto initWinResultDto(LottoDtos lottoDtos) {
        WinResultDto winResultDto = null;
        try {
            WinningLotto winningLotto = new WinningLotto(Lotto.initArtifitial(getWinningLotto().getLottoDto()), inputBonusNum());
            winResultDto = winningLotto.checkWins(lottoDtos);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return initWinResultDto(lottoDtos);
        }
        return winResultDto;
    }

}
