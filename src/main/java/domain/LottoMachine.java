package domain;

import static java.util.stream.Collectors.toList;

import dto.LottoResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import util.RandomGenerator;

public class LottoMachine {

  private static final int PRICE_PER_LOTTO_ONE_GAME = 1000;
  private List<Lotto> lottos;

  public LottoMachine() {
    this.lottos = new ArrayList<>();
  }

  public int getLottoCount(int money) {
    return money / PRICE_PER_LOTTO_ONE_GAME;
  }

  public List<Lotto> issue(int count) {
    IntStream.rangeClosed(1, count)
        .forEach(i -> add(new Lotto(RandomGenerator.generateNumbers())));
    return lottos;
  }

  public void add(Lotto lotto) {
    this.lottos.add(lotto);
  }

  public static Lotto createWinningLotto(String strNumbers) {
    String[] numbers = strNumbers.split(",");
    List<Integer> winningNumbers = Arrays.stream(numbers)
        .map(n -> Integer.parseInt(n))
        .collect(toList());
    return new Lotto(winningNumbers);
  }

  public LottoResult match(Lotto winningLotto) {
    LottoResult result = new LottoResult();
    Arrays.stream(Rank.values()).forEach(r -> {
      result.add(r, getRankOfCount(r, winningLotto));
    });
    result.setRevenue(getRevenue(winningLotto));
    return result;
  }

  public int getRankOfCount(Rank rank, Lotto winningLotto) {
    return (int) lottos.stream()
        .filter(l -> l.getCountOfMatchNumber(winningLotto) == rank.getMatchOfNumberCnt())
        .count();
  }

  public double getRevenue(Lotto winningLotto) {
    int totalPrizeMoney = Arrays.stream(Rank.values())
        .mapToInt(r -> r.getWinningMoney() * getRankOfCount(r, winningLotto))
        .sum();
    return ((double) totalPrizeMoney / (PRICE_PER_LOTTO_ONE_GAME * lottos.size())) * 100;
  }
}
