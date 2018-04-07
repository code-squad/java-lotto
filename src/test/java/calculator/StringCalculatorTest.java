package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sangsik.kim
 */
public class StringCalculatorTest {

    @Test
    public void 빈문자열_입력() {
        int result = StringCalculator.sum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void null_입력() {
        int result = StringCalculator.sum(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 숫자_한개_입력() {
        int result = StringCalculator.sum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 콤마로_구분하여_입력() {
        int result = StringCalculator.sum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 콜론으로_구분하여_입력() {
        int result = StringCalculator.sum("1:2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 콤마와_세미콜론으로_구분하여_입력() {
        int result = StringCalculator.sum("1,2:3:4,5");
        assertThat(result).isEqualTo(15);
    }

    @Test
    public void 커스텀_구분자를_사용() {
        int result = StringCalculator.sum("//@\n1@2@3");
        assertThat(result).isEqualTo(6);
    }

    @Test(expected = RuntimeException.class)
    public void 음수를_입력했을때_익셉션_발생() {
        StringCalculator.sum("-1:1");
    }
}
