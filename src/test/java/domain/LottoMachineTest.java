package domain;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import view.ResultView;

public class LottoMachineTest {

  private LottoMachine lottoMachine;
  private Lotto winningLotto;

  @Before
  public void setUp() throws Exception {
    lottoMachine = new LottoMachine();
    winningLotto = LottoMachine.createWinningLotto("1,2,3,4,5,6");
  }

  @Test
  public void 금액입력_로또게임수_반환() {
    assertEquals(14, lottoMachine.getLottoCount(14000));
    assertEquals(20, lottoMachine.getLottoCount(20000));
  }

  @Test
  public void 입력한금액만큼_로또게임_발행() {
    List<Lotto> lottos = lottoMachine.issue(14);
    assertEquals(14, lottos.size());
  }

  @Test
  public void getRankOfCount() {
    // 1등
    lottoMachine.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

    // 2등
    lottoMachine.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
    lottoMachine.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)));

    // 3등
    lottoMachine.add(new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)));
    lottoMachine.add(new Lotto(Arrays.asList(1, 2, 3, 4, 13, 15)));
    lottoMachine.add(new Lotto(Arrays.asList(1, 2, 3, 4, 29, 44)));

    // 4등
    lottoMachine.add(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
    assertEquals(1, lottoMachine.getRankOfCount(Rank.FIRST, winningLotto));
    assertEquals(2, lottoMachine.getRankOfCount(Rank.SECOND, winningLotto));
    assertEquals(3, lottoMachine.getRankOfCount(Rank.THIRD, winningLotto));
    assertEquals(1, lottoMachine.getRankOfCount(Rank.FOURTH, winningLotto));
  }

  @Test
  public void getRevenue() {
    lottoMachine.add(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
    assertEquals("500", ResultView.formatToRevenue(lottoMachine.getRevenue(winningLotto)));
  }
}
