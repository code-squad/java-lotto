package domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RankTest {

  @Test
  public void valueOf() {
    assertEquals(Rank.FIRST, Rank.valueOf(6, false));
    assertEquals(Rank.SECOND, Rank.valueOf(5, true));
    assertEquals(Rank.THIRD, Rank.valueOf(5, false));
    assertEquals(Rank.FOURTH, Rank.valueOf(4, false));
    assertEquals(Rank.FIFTH, Rank.valueOf(3, false));
    assertEquals(Rank.ZERO, Rank.valueOf(2, false));
    assertEquals(Rank.ZERO, Rank.valueOf(1, false));
    assertEquals(Rank.ZERO, Rank.valueOf(0, false));
  }
}
