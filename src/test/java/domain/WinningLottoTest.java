package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class WinningLottoTest {

  private WinningLotto winningLotto;

  @Before
  public void setUp() throws Exception {
    winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void 로또번호에_포함된_보너스_번호입력시_익셉션() throws Exception {
    winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 5);
  }

  @Test
  public void 보너스_번호_일치() throws Exception {
    assertTrue(winningLotto.isBonusNumber(7));
    assertFalse(winningLotto.isBonusNumber(8));
  }
}
