package util;

import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Test;

public class RandomGeneratorTest {

  @Test
  public void 랜덤값_생성() {
    List<Integer> numbers = RandomGenerator.generateNumbers();
    System.out.println("numbers = " + numbers);
    for (Integer n : numbers) {
      assertTrue(n > 0 && n < 46);
    }
  }
}
