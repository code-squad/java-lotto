package calculatorTest;

import calculator.StringCalculator;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.assertThat;
/**
 *
 */
public class stringCalculatorTest {
    private StringCalculator cal;

    @Before
    public void setup(){
        cal = new StringCalculator();
    }

    @Test
    public void add_null_또는_빈문자열(){
        assertThat(0, is(cal.add(null)));
        assertThat(0, is(cal.add("")));
    }

    @Test
    public void add_숫자하나입력(){
        assertThat(1, is(cal.add("1")));
    }

    @Test
    public void add_쉼표_또는_콜론_구분자(){
        assertThat(6, is(cal.add("3,3")));
    }
}
