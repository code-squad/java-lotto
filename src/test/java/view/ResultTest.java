package view;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    private Result result;

    @Before
    public void setup() {
        result = new Result(14000);
    }

    @Test
    public void 로또를_산_갯수() {
        assertThat(result.countOfLotto()).isEqualTo(14);
    }
}
