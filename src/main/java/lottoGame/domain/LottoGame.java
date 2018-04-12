package lottoGame.domain;

import java.util.List;

import static lottoGame.view.ResultView.*;
import static lottoGame.view.InputView.*;

public class LottoGame {

    public static void main(String[] args) {

        LottoMachine lottoMachine = new LottoMachine();
        int lottoTiketPrices = inputLottoPrice();
        List<Lotto> lottoes = lottoMachine.giveLottoTiket(lottoTiketPrices);

        printLottoTiketCnt(lottoes);
        printLottoNumbers(lottoes);
        printPrizeStaicResult(LottoStaticResult.makeLottoStaticResult(lottoes,inputLuckyNumbers()),lottoTiketPrices);
    }
}
