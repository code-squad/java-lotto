package domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

  private List<LottoNumber> numbers;

  public Lotto(List<Integer> numbers) {
    this.numbers = new ArrayList<>(6);
    numbers.stream().forEach(n -> this.numbers.add(new LottoNumber(n)));
  }

  public int getCountOfMatchNumber(Lotto winningLotto) {
    return (int) winningLotto.numbers.stream()
          .filter(w -> containWinningNumber(w.getNumber()))
          .count();
  }

  private boolean containWinningNumber(int winningNumber) {
    return numbers.stream().anyMatch(n -> n.isWinningNumber(winningNumber));
  }

  @Override
  public String toString() {
    return numbers.toString();
  }
}
