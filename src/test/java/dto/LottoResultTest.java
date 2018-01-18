package dto;

import domain.Lotto;
import domain.LottoMachine;
import domain.WinningLotto;
import org.junit.Before;
import org.junit.Test;
import view.ResultView;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LottoResultTest {
  private LottoMachine lottoMachine;
  private WinningLotto winningLotto;

  @Before
  public void setUp() throws Exception {
    lottoMachine = new LottoMachine();
    winningLotto = LottoMachine.createWinningLotto("1,2,3,4,5,6", 7);
  }

  @Test
  public void getRevenue() {
    lottoMachine.add(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
    LottoResult result = lottoMachine.match(winningLotto);
    assertEquals("500", ResultView.formatToRevenue(result.getRevenue()));
  }
}
