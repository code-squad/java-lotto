package step0_2;

import org.junit.Before;
import org.junit.Test;
import step0_2.ValidaitonUtil;

public class ValidationUtilTest {

  ValidaitonUtil vu = null;

  @Before
  public void setUp() throws Exception {
    vu = new ValidaitonUtil();
  }

  @Test(expected = IllegalArgumentException.class)
  public void 빈_문자열일_경우_IllegalArgumentException를_던지는지_확인() {
    vu.checkBlank("  ");
  }

  @Test(expected = RuntimeException.class)
  public void 숫자_이외의_값을_전달하면_RuntimeException를_던짐() {
    vu.checkDigit("나는문자열");
  }

  @Test(expected = RuntimeException.class)
  public void 음수를_전달하면_RuntimeException를_던짐() {
    vu.checkNotNegative(-5);
  }

}
