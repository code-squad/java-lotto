package step0_1;

import org.junit.Test;

public class ValidationUtilTest {

  @Test(expected = IllegalArgumentException.class)
  public void 빈_문자열일_경우_IllegalArgumentException를_던지는지_확인() {
    ValidaitonUtil.checkBlank("  ");
  }

  @Test(expected = RuntimeException.class)
  public void 숫자_이외의_값을_전달하면_RuntimeException를_던짐() {
    ValidaitonUtil.checkDigit("나는문자열");
  }

  @Test(expected = RuntimeException.class)
  public void 음수를_전달하면_RuntimeException를_던짐() {
    ValidaitonUtil.checkNotNegative("-5");
  }

}
