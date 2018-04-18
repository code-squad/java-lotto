package lottoGame;

import org.junit.Test;

import javax.naming.NoPermissionException;

import static lottoGame.AddCalculator.add;
import static org.assertj.core.api.Assertions.assertThat;

public class AddCalculatorTest {

    @Test
    public void add_숫자하나(){
        assertThat(add("1")).isEqualTo(1);
        assertThat(add("2")).isEqualTo(2);
    }

    @Test
    public void add_null_빈문자(){
        assertThat(add("")).isEqualTo(0);
        assertThat(add(null)).isEqualTo(0);
    }


    @Test
    public void add_쉼표구분자(){
        assertThat(add("1,2")).isEqualTo(3);
        assertThat(add("5,4")).isEqualTo(9);
    }

    @Test
    public void add_쉼표또는콜론구분자(){
        assertThat(add("1,2:3")).isEqualTo(6);
    }

    @Test
    public void add_커스텀구분자(){
        assertThat(add("//;\n1;2;3")).isEqualTo(6);
    }

    @Test(expected=Exception.class)
    public void add_음수처리() throws Exception {
        assertThat(add("-1"));
        assertThat(add("-1,3"));

    }


}
