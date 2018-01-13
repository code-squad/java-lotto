package util;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class RandomGenerator {

  public static List<Integer> generateNumber() {
    Integer[] numbers = new Integer[45];
    IntStream.rangeClosed(1, 45).forEach(i -> numbers[i-1] = i);
    List<Integer> randoms = Arrays.asList(numbers);
    Collections.shuffle(randoms);
    return randoms.stream()
            .limit(6)
            .sorted()
            .collect(toList());
  }
}
