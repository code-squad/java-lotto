package dto;

import domain.Lotto;
import domain.Rank;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoResult {

  private static final int PRICE_PER_LOTTO_ONE_GAME = 1000;
  private List<Lotto> lottos;
  private List<Integer> winningNumbers;

  public LottoResult(List<Integer> winningNumbers) {
    this.lottos = new ArrayList<>();
    this.winningNumbers = winningNumbers;
  }

  public void add(Lotto lotto) {
    lottos.add(lotto);
  }

  public int getRankOfCount(Rank rank) {
    return (int) lottos.stream()
        .filter(l -> l.getCountOfMatchNumber(winningNumbers) == rank.getMatchOfNumberCnt())
        .count();
  }

  public double getRevenue() {
    Rank[] ranks = Rank.values();
    int totalPrizeMoney = Arrays.stream(ranks)
        .mapToInt(r -> r.getWinningMoney() * getRankOfCount(r))
        .sum();
    return ((double) totalPrizeMoney / (PRICE_PER_LOTTO_ONE_GAME * lottos.size())) * 100;
  }

  public String getFormatToRevenue() {
    return new DecimalFormat("0.##").format(getRevenue());
  }
}
