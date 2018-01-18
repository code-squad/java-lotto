package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class LottoTest {

  private WinningLotto winningLotto;

  @Before
  public void setUp() throws Exception {
    winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
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

  @Test
  public void 보너스_번호_포함여부_확인() throws Exception {
    Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
    assertTrue(lotto.containBonusNumber(winningLotto));

    lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    assertFalse(lotto.containBonusNumber(winningLotto));
  }

  @Test
  public void 로또_당첨_결과() throws Exception {
    Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    assertEquals(Rank.FIRST, lotto.match(winningLotto));

    lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
    assertEquals(Rank.SECOND, lotto.match(winningLotto));

    lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
    assertEquals(Rank.THIRD, lotto.match(winningLotto));

    lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9));
    assertEquals(Rank.FOURTH, lotto.match(winningLotto));

    lotto = new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10));
    assertEquals(Rank.FIFTH, lotto.match(winningLotto));

    lotto = new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16));
    assertEquals(Rank.ZERO, lotto.match(winningLotto));
  }
}
