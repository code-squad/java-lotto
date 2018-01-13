package domain;

import org.junit.Test;
import util.RandomGenerator;

public class LottoTest {

  @Test
  public void 로또_발행() {
    new Lotto(RandomGenerator.generateNumber());
  }
}
