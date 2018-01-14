package domain;

import dto.LottoResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import util.RandomGenerator;

public class LottoMachine {

  private static final int PRICE_PER_LOTTO_ONE_GAME = 1000;
  private List<Lotto> lottos;
  private List<Integer> winningNumbers;

  public LottoMachine() {
    this.lottos = new ArrayList<>();
  }

  public int getLottoCount(int money) {
    return money / PRICE_PER_LOTTO_ONE_GAME;
  }

  public List<Lotto> issue(int count) {
    IntStream.rangeClosed(1, count)
        .forEach(i -> lottos.add(new Lotto(RandomGenerator.generateNumbers())));
    return lottos;
  }

  public void setWinningNumbers(String strNumbers) {
    String[] numbers = strNumbers.split(",");
    this.winningNumbers = Arrays.stream(numbers)
        .map(n -> Integer.parseInt(n))
        .collect(Collectors.toList());
  }

  public LottoResult getResult() {
    LottoResult result = new LottoResult(winningNumbers);
    lottos.stream().forEach(lotto -> result.add(lotto));
    return result;
  }
}
