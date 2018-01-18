package domain;

import util.Constants;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

  private List<LottoNumber> numbers;

  public Lotto(List<Integer> numbers) {
    this.numbers = new ArrayList<>(Constants.NUMBER_SIZE);
    numbers.stream().forEach(n -> this.numbers.add(new LottoNumber(n)));
  }

  public Rank match(WinningLotto winningLotto) {
    return Rank.valueOf(getCountOfMatchNumber(winningLotto), containBonusNumber(winningLotto));
  }

  public int getCountOfMatchNumber(WinningLotto winningLotto) {
    return (int) winningLotto.getNumbers().stream()
        .filter(w -> containWinningNumber(w.getNumber()))
        .count();
  }

  private boolean containWinningNumber(int winningNumber) {
    return numbers.stream().anyMatch(n -> n.isEqualNumber(winningNumber));
  }

  public boolean containBonusNumber(WinningLotto winningLotto) {
    return numbers.stream()
        .anyMatch(number -> winningLotto.isBonusNumber(number.getNumber()));
  }

  public List<LottoNumber> getNumbers() {
    return numbers;
  }

  @Override
  public String toString() {
    return numbers.toString();
  }
}
