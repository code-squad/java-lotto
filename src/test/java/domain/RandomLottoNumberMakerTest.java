package domain;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class RandomLottoNumberMakerTest {

  @Test
  public void 랜덤_로또번호_발급() throws Exception {
    LottoNumberMaker lottoNumberMaker = new RandomLottoNumberMaker();
    List<Integer> numbers = lottoNumberMaker.issueLottoNumbers();
    for (Integer n : numbers) {
      assertTrue(n > 0 && n < 46);
    }
  }
}
