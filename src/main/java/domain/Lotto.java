package domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

  private static final int NUMBER_COUNT = 6;
  private List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    numbers = new ArrayList<>(NUMBER_COUNT);
    this.numbers = numbers;
  }

}
