package calculator;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class StringCalculatorTest {

    @Test
    public void 식이_없으면_0을_반환() {
        Assertions.assertThat(StringCalculator.add("")).isEqualTo(0);
    }

    @Test
    public void 식이_null_이면_반환() {
        Assertions.assertThat(StringCalculator.add(null)).isEqualTo(0);
    }

    @Test(expected = NumberFormatException.class)
    public void 숫자_이외의_값만_있으면_예외가_발생한다() {
        StringCalculator.add("a:b,c");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void 음수_값이_포함되어_있으면_예외가_발생한다() {
        StringCalculator.add("-1");
    }

    @Test
    public void comma_로_구분된_숫자들을_더한다() {
        Assertions.assertThat(StringCalculator.add("1,2")).isEqualTo(3);
    }

    @Test
    public void colon_로_구분된_숫자들을_더한다() {
        Assertions.assertThat(StringCalculator.add("3:4")).isEqualTo(7);
    }

    @Test
    public void comma_와_colon_으로_구분된_숫자들을_더한다() {
        Assertions.assertThat(StringCalculator.add("1,2:3")).isEqualTo(6);
    }

    @Test
    public void custom_구분자로_구분된_숫자들을_더한다() {
        Assertions.assertThat(StringCalculator.add("//;\n1;2;3")).isEqualTo(6);
    }
}
