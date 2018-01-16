package dto;

import domain.Rank;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {

  private Map<Rank, Integer> results;
  private double revenue;

  public LottoResult() {
    results = new HashMap<>();
  }

  public void add(Rank rank, int winnerCount) {
    this.results.put(rank, winnerCount);
  }

  public int getRankOfCount(Rank rank) {
    return results.get(rank);
  }

  public void setRevenue(double revenue) {
    this.revenue = revenue;
  }

  public double getRevenue() {
    return revenue;
  }
}
