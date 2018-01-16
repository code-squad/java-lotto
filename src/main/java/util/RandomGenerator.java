package util;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class RandomGenerator {

  private static final int MAX_NUMBER = 45;
  private static final int NUMBER_SIZE = 6;

  public static List<Integer> generateNumbers() {
    List<Integer> randoms = IntStream.iterate(1, n -> n + 1).boxed().limit(MAX_NUMBER).collect(toList());
    Collections.shuffle(randoms);
    return randoms.stream()
            .limit(NUMBER_SIZE)
            .sorted()
            .collect(toList());
  }
}
