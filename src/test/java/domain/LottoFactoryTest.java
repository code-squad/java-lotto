package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoFactoryTest {

    private List<LottoNum> lottos;

    @Before
    public void setUp() {
        lottos = new ArrayList<LottoNum>();
        for(int i = 1; i <= 6; i++) {
            lottos.add(new LottoNum(i));
        }
    }

    @Test
    public void isValidFormatTest() {
        assertThat(LottoFactory.isValidFormat("1, 2, 3, 4, 5, 6")).isTrue();
        assertThat(LottoFactory.isValidFormat("1, 2, 3, 4, 5,6")).isFalse();
    }
}
