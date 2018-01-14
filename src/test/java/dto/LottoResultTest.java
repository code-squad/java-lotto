package dto;

import static org.junit.Assert.assertEquals;

import domain.Lotto;
import domain.Rank;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class LottoResultTest {

  private LottoResult result;

  @Before
  public void setUp() throws Exception {
    List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    result = new LottoResult(winningNumbers);
  }

  @Test
  public void getRankOfCount() {
    // 1등
    result.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

    // 2등
    result.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
    result.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)));

    // 3등
    result.add(new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)));
    result.add(new Lotto(Arrays.asList(1, 2, 3, 4, 13, 15)));
    result.add(new Lotto(Arrays.asList(1, 2, 3, 4, 29, 44)));

    // 4등
    result.add(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
    assertEquals(1, result.getRankOfCount(Rank.FIRST));
    assertEquals(2, result.getRankOfCount(Rank.SECOND));
    assertEquals(3, result.getRankOfCount(Rank.THIRD));
    assertEquals(1, result.getRankOfCount(Rank.FOURTH));
  }

  @Test
  public void getRevenue() {
    result.add(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
    assertEquals("500", result.getFormatToRevenue());
  }
}
