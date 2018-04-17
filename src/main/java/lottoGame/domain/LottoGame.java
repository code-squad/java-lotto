package lottoGame.domain;

import java.util.List;

import static lottoGame.view.InputView.inputHandOperatedLottoCount;
import static lottoGame.view.ResultView.*;
import static lottoGame.view.InputView.*;

public class LottoGame {

    public static void main(String[] args) {

        try {
            LottoMachine lottoMachine = new LottoMachine();
            int lottoTiketPrices = inputLottoPrice();
            int handOperatedLottoCount = inputHandOperatedLottoCount();

            List<Lotto> lottoes = lottoMachine.getLottoTiket(lottoTiketPrices, handOperatedLottoCount);

            printHandOperatedLottoGuide();
            addHandOperatedLotto(handOperatedLottoCount, lottoes);

            printLottoTiketCount(lottoes, handOperatedLottoCount);
            printLottoNumbers(lottoes);
            printPrizeStaicResult(LottoStaticResult.makeLottoStaticResult(lottoes, new WinningLotto(new Lotto(inputLuckyNumbers()), inputBonusLottoBall())), lottoTiketPrices);

        } catch(Exception ex) {

            System.out.println(ex.getClass());
            System.out.println(ex.getMessage());
        }
    }

    private static void addHandOperatedLotto(int handOperatedLottoCount, List<Lotto> lottoes) {
        for(int i = 0; i < handOperatedLottoCount; i++) {
            lottoes.add(new Lotto(inputHandOperatedLottoNumbers()));
        }
    }
}
