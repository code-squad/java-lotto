package lotttoOlder;

import java.util.Map;
import java.util.Objects;

public class LottoResult {

//  TODO Lottos 그냥 넘기면 안됨?
  Map<String, Integer> matchNumresult;

  public LottoResult(Map<String, Integer> matchNumresult) {
    this.matchNumresult = matchNumresult;
  }

  public double calProfit(int lottoGameCount) {
    return 100.0 * sumPrize() / (LottoInfo.LOTTO_PRICE * lottoGameCount);
  }

  private int sumPrize() {
    int prize = 0;

    for (LottoInfo li : LottoInfo.values()) {
      prize += li.getPrize() * matchNumresult.getOrDefault(li.getMapKey(), 0);
    }
    return prize;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoResult that = (LottoResult) o;
    return Objects.equals(matchNumresult, that.matchNumresult);
  }

  @Override
  public int hashCode() {

    return Objects.hash(matchNumresult);
  }

  @Override
  public String toString() {
    return "LottoResult{" +
        "matchNumresult=" + matchNumresult +
        '}';
  }
}
