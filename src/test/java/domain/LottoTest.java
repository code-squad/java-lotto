package domain;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class LottoTest {

  private Lotto winningLotto;

  @Before
  public void setUp() throws Exception {
    winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
  }

  @Test
  public void 일치하는_숫자_갯수_확인() {
    Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    assertEquals(6, lotto.getCountOfMatchNumber(winningLotto));

    lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
    assertEquals(5, lotto.getCountOfMatchNumber(winningLotto));

    lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8));
    assertEquals(4, lotto.getCountOfMatchNumber(winningLotto));

    lotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
    assertEquals(3, lotto.getCountOfMatchNumber(winningLotto));
  }
}
