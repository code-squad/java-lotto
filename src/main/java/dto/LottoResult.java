package dto;

import domain.Rank;
import util.Constants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {

  private Map<Rank, Integer> results;

  public LottoResult() {
    results = new HashMap<>();
    Arrays.stream(Rank.values()).forEach(r -> results.put(r, 0));
  }

  public void add(Rank rank, int winnerCount) {
    this.results.put(rank, winnerCount);
  }

  public int getRankOfCount(Rank rank) {
    return results.get(rank);
  }

  public double getRevenue() {
    return ((double) getTotalPrizeMoney() / (Constants.PRICE_PER_LOTTO_ONE_GAME * getlottoCount())) * 100;
  }

  private int getTotalPrizeMoney() {
    return Arrays.stream(Rank.values())
        .mapToInt(r -> r.getWinningMoney() * getRankOfCount(r))
        .sum();
  }

  private int getlottoCount() {
    return results.values().stream().mapToInt(i -> i).sum();
  }
}
