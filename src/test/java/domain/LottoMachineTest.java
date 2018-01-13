package domain;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class LottoMachineTest {

  private LottoMachine lottoMachine;

  @Before
  public void setUp() throws Exception {
    lottoMachine = new LottoMachine();
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
}
