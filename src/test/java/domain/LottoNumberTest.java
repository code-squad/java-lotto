package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class LottoNumberTest {

  @Test
  public void lottoNumber_생성() {
    LottoNumber lottoNumber = new LottoNumber(10);
    assertEquals(new LottoNumber(10), lottoNumber);
  }

  @Test(expected = IllegalArgumentException.class)
  public void lottoNumber_유효성_검사() {
    new LottoNumber(46);
    fail("1~45 숫자만 유효합니다.");
  }

  @Test
  public void match_숫자_일치() {
    int winningNumber = 10;
    LottoNumber lottoNumber = new LottoNumber(10);
    assertTrue(lottoNumber.isWinningNumber(winningNumber));

    lottoNumber = new LottoNumber(9);
    assertFalse(lottoNumber.isWinningNumber(winningNumber));
  }
}
