package lotttoOlder;

public class LottoGame {

  public int getLottoGameNum(String money) {
    return Integer.parseInt(money) / 1000;
  }

  public LottoResult match(Lotto jackpot, Lottos lottos) {
    return new LottoResult(lottos.match(jackpot));
  }

}
