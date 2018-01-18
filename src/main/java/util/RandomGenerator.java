package util;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class RandomGenerator {

  public static List<Integer> generateNumbers() {
    List<Integer> randoms = IntStream.iterate(1, n -> n + 1).boxed().limit(Constants.MAX_NUMBER).collect(toList());
    Collections.shuffle(randoms);
    return randoms.stream()
            .limit(Constants.NUMBER_SIZE)
            .sorted()
            .collect(toList());
  }
}
