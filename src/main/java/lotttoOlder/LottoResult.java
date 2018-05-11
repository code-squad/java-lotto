package lotttoOlder;

import java.util.Map;
import java.util.Objects;

public class LottoResult {

  int match3Count;
  int match4Count;
  int match5Count;
  int match6Count;

  public LottoResult(Map<String, Integer> map) {
    this.match3Count = map.getOrDefault(LottoRule.valueOf(FIRST) ,0);

    this.match3Count = map.getOrDefault(MatchKey.MATCH_3NUM_KEY,0);
    this.match4Count = map.getOrDefault(MatchKey.MATCH_4NUM_KEY,0);
    this.match5Count = map.getOrDefault(MatchKey.MATCH_5NUM_KEY,0);
    this.match6Count = map.getOrDefault(MatchKey.MATCH_6NUM_KEY,0);
  }

  public double getRateOfReturn(int lottoGameCount) {
    return 100 * (Prize.MATCH_3NUM_PRIZE * this.match3Count + Prize.MATCH_4NUM_PRIZE * this.match4Count
        + Prize.MATCH_5NUM_PRIZE * this.match5Count + Prize.MATCH_6NUM_PRIZE * this.match6Count) / (LottoInfo.LOTTO_PRICE * lottoGameCount);
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
    return match3Count == that.match3Count &&
        match4Count == that.match4Count &&
        match5Count == that.match5Count &&
        match6Count == that.match6Count;
  }

  @Override
  public int hashCode() {

    return Objects.hash(match3Count, match4Count, match5Count, match6Count);
  }
}
