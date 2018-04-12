package StringCalculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @Before
    public void setUp() throws Exception {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void start(){
    }

    @Test
    public void cal() throws Exception {
        int result = stringCalculator.add("1:2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 널입력0반환() throws Exception {
        int result = stringCalculator.add(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 입력0반환() throws Exception {
        int result = stringCalculator.add("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 더하기() throws Exception {
        int result = stringCalculator.add("1,2:4");
        assertThat(result).isEqualTo(7);
    }

    @Test
    public void 더하기커스텀구분자() throws Exception {
        int result = stringCalculator.add("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    //음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)
    @Test(expected = RuntimeException.class)
    public void 음수를전달할경우runtimeException() throws Exception {
       stringCalculator.add("-1:-3,-2");

    }
}
