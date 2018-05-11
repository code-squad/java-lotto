package lotttoOlder.utility;

import org.junit.Before;
import org.junit.Test;

public class ParserTest {

  Parser parserInLotto;

  @Before
  public void setUp() throws Exception {
    parserInLotto = new Parser();
  }

  @Test(expected = IllegalArgumentException.class)
  public void 입력값이_숫자가_아닐때_IllegalArgumentException_던짐() {
    parserInLotto.validateDigit("나는문자열");
  }

  @Test(expected = IllegalArgumentException.class)
  public void 입력받은_번호묶음이_숫자가_아니면_IllegalArgumentException_던짐() {
    parserInLotto.splitor("문자,3,4,5,6,7");
  }

  @Test(expected = IllegalArgumentException.class)
  public void 입력받은_번호묶음이_로또숫자범위가_아니면_IllegalArgumentException_던짐() {
    parserInLotto.splitor("234,3,4,5,6,7");
  }

  @Test(expected = IllegalArgumentException.class)
  public void 입력받은_번호묶음에_중복되는_숫자가_있으면_IllegalArgumentException_던짐() {
    parserInLotto.splitor("3,3,4,5,6,7");
  }

}