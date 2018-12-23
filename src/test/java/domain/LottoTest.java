package domain;

import org.junit.Test;
import support.Fixture;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertTrue;


public class LottoTest extends Fixture {
    @Test
    public void ofListTest() {
        assertTrue(Lotto.ofList(LOTTONUMS1) instanceof Lotto);
    }

    @Test
    public void ofTest() {
        assertThat(Lotto.of("6,7,8,9,10,11")).isEqualTo(Lotto.ofList(LOTTONUMS4));
        System.out.println(Lotto.of("6,7,8,9,10,11"));
    }

    @Test
    public void checkNumTest() {
        Lotto lotto1 = Lotto.ofList(LOTTONUMS1);
        Lotto lotto2 = Lotto.ofList(LOTTONUMS2);

        assertThat(lotto1.checkNum(lotto2)).isEqualTo(5);
    }

}