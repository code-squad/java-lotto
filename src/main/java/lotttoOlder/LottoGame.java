package lotttoOlder;

import lotttoOlder.view.InputView;
import lotttoOlder.view.OutputView;

public class LottoGame {

  public static void main(String[] args){

    int lottoGameNum = getLottoGameNum(InputView.getLottoGameMoney());
    OutputView.printPurchaseInfo(lottoGameNum);

    Lottos lottos = new Lottos(lottoGameNum);
    OutputView.printLottosNum(lottos,", ");
  }

  public static int getLottoGameNum(String money) {
    return Integer.parseInt(money) / 1000;
  }

  public LottoResult match(Lotto jackpot, Lottos lottos) {
    return new LottoResult(lottos.match(jackpot));
  }
}
