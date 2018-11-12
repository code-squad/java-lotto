package lotto;

import lotto.domain.Lotto;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMainTest {
    @Test
    public void 분리() {
        String input = "1,2,3,4,5,6\n3,2,1,6,13,24";
        String[] result = input.split("\r?\n");
        assertThat(result[0]).isEqualTo("1,2,3,4,5,6");
        assertThat(result[1]).isEqualTo("3,2,1,6,13,24");
    }
}
