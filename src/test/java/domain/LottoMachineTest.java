package domain;

import static org.junit.Assert.assertEquals;

import dto.LottoResult;
import java.util.Arrays;
import java.util.List;

import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import view.ResultView;

public class LottoMachineTest {

  private LottoMachine lottoMachine;
  private WinningLotto winningLotto;

  @Before
  public void setUp() throws Exception {
    lottoMachine = new LottoMachine();
    lottoMachine.setLottoNumberMaker(new RandomLottoNumberMaker());
    winningLotto = LottoMachine.createWinningLotto("1,2,3,4,5,6", 7);
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

    // 3등
    lottoMachine.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)));

    // 4등
    lottoMachine.add(new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)));
    lottoMachine.add(new Lotto(Arrays.asList(1, 2, 3, 4, 13, 15)));
    lottoMachine.add(new Lotto(Arrays.asList(1, 2, 3, 4, 29, 44)));

    // 5등
    lottoMachine.add(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));

    Map<String, Long> rankOfCount = lottoMachine.getRankOfCount(winningLotto);

    assertEquals(1, rankOfCount.get(Rank.FIRST.name()).intValue());
    assertEquals(1, rankOfCount.get(Rank.SECOND.name()).intValue());
    assertEquals(1, rankOfCount.get(Rank.THIRD.name()).intValue());
    assertEquals(3, rankOfCount.get(Rank.FOURTH.name()).intValue());
    assertEquals(1, rankOfCount.get(Rank.FIFTH.name()).intValue());
  }
}
