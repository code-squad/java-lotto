package calculator;

import org.junit.Test;

import static calculator.StringCalculator.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {

    @Test
    public void add_숫자하나() {
        assertThat(add("1")).isEqualTo(1);
    }

    @Test
    public void add_컴마구분자() {
        assertThat(add("1,2,3")).isEqualTo(6);
    }

    @Test
    public void add_콜론구분자() {
        assertThat(add("1:2:3")).isEqualTo(6);
    }

    @Test
    public void add_커스텀구분자() {
        assertThat(add("//;\n1;2;3")).isEqualTo(6);
    }

    @Test(expected = RuntimeException.class)
    public void add_잘못된값_숫자가아닌값() {
        add("a,b,c");
    }

    @Test(expected = RuntimeException.class)
    public void add_잘못된값_음수() {
        add("-1,0,1");
    }
}
