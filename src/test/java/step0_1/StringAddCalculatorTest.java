package step0_1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class StringAddCalculatorTest {

  StringAddCalculator sac;

  @Before
  public void setUp() {
    sac = new StringAddCalculator();
  }

  @Test
  public void 덧셈이_정상적으로_이루어지는_확인() {
    assertThat(sac.add("//;\n4.56;6.78")).isEqualTo(11.34);
  }

  @Test(expected = RuntimeException.class)
  public void 잘못된_입력값일_경우_덧셈연산시_Exception을_던지는지_확인() {
    assertThat(sac.add("//;\n4.56+6.78")).isEqualTo(11.34);
  }
}