package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {
    @Test
    public void 빈값_입력() {
        assertEquals(0, StringCalculator.add(""));
        assertEquals(0, StringCalculator.add(null));
    }

    @Test
    public void 단일숫자_입력() {
        int result = StringCalculator.add("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 콤마_입력_구분() {
        int result = StringCalculator.add("1,3");
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void 세미콜론_입력_구분() {
        int result = StringCalculator.add("1:3");
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void 콤마_세미콜론_혼합입력() {
        int result = StringCalculator.add("1:3,4");
        assertThat(result).isEqualTo(8);
    }

    @Test
    public void 커스텀_입력_구분() {
        int result = StringCalculator.add("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test(expected = RuntimeException.class)
    public void 음수체크() {
        StringCalculator.add("-1, 3");
    }

    @Test(expected = RuntimeException.class)
    public void 숫자아닌지체크() {
        StringCalculator.add("a, 3");
    }
}
