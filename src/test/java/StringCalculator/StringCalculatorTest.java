package StringCalculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    public void 더하기() {
        assertThat(StringCalculator.add("1:2:3")).isEqualTo(6);
    }

    @Test
    public void 구분자_두개사용() {
        assertThat(StringCalculator.add("1,2:3")).isEqualTo(6);
    }

    @Test
    public void 구분자없음() {
        assertThat(StringCalculator.add("123")).isEqualTo(123);
    }

    @Test
    public void 빈값입력() {
        assertThat(StringCalculator.add("")).isEqualTo(0);
    }

    @Test
    public void null입력() {
        assertThat(StringCalculator.add(null)).isEqualTo(0);
    }

    @Test
    public void 커스텀_구분자() {
        assertThat(StringCalculator.add("//;\n1;2;3")).isEqualTo(6);
    }

    @Test(expected = RuntimeException.class)
    public void 음수입력() {
        assertThat(StringCalculator.add("-1:-2,3"));
    }

    @Test(expected = RuntimeException.class)
    public void 다른문자열입력() {
        assertThat(StringCalculator.add("1:2:가"));
    }

}