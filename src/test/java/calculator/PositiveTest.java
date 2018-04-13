package calculator;

import org.junit.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PositiveTest {
    @Test(expected = IllegalArgumentException.class)
    public void 음수숫자입력() {
        Positive positive = new Positive(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 음수문자입력() {
        Positive positive = new Positive("-1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 숫자아닌값_입력() {
        Positive positive = new Positive("aa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void null입력() {
        Positive positive = new Positive(null);
    }

    @Test
    public void 양수숫자입력() {
        Positive positive = new Positive(1);
        assertThat(positive.getNumber()).isEqualTo(1);
    }

    @Test
    public void 양수문자입력() {
        Positive positive = new Positive("10");
        assertThat(positive.getNumber()).isEqualTo(10);
    }
}
