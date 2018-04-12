package lottoGame;

import org.junit.Test;

import static lottoGame.Calculator.addOperate;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    public void 빈문자열던지기() {
        assertThat(addOperate("")).isEqualTo(0);
    }

    @Test
    public void 널문자열던지기() {
        assertThat(addOperate(null)).isEqualTo(0);
    }

    @Test
    public void 쉼표구분자로_더하기() {
        assertThat(addOperate("1,2")).isEqualTo(3);
    }

    @Test
    public void 쉼표구분자로_세가지이상수_더하기() {
        assertThat(addOperate("1,2,3")).isEqualTo(6);
    }

    @Test
    public void 쉼표와콜론_섞은수_더하기() {
        assertThat(addOperate("1,2:3")).isEqualTo(6);
    }

    @Test
    public void 커스텀구분자_섞은수_더하기() {
        assertThat(addOperate("//;\n1;2;3")).isEqualTo(6);
        assertThat(addOperate("//o\n1,2o3:5:8,10")).isEqualTo(29);
    }

    @Test(expected = RuntimeException.class)
    public void 숫자이외의값이들어갔을때() {
        addOperate("ㄱ,1,2,s");
    }

    @Test(expected = RuntimeException.class)
    public void 음수값이들어갔을때() {
        addOperate("-1,2,3");
    }

    @Test(expected = RuntimeException.class)
    public void 임의값이들어갔을때() {
        addOperate("//s\n3sg14,5");
    }
}