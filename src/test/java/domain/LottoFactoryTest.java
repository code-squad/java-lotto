package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    @Test
    public void randomTest() {
        Stream.generate(Math::random).limit(100).forEach((n) -> System.out.println(n));
    }

    /* 당첨결과 문자열을 쪼개는 메소드 */

    @Test
    public void createLottoNumbersTest() {
        assertThat(LottoFactory.createLottoNumbers("1, 2, 3, 4, 5, 6").get(1)).isEqualTo(new LottoNum(2));
        assertThat(LottoFactory.createLottoNumbers("1, 2, 3, 4, 5, 6").get(2)).isEqualTo(new LottoNum(3));
        assertThat(LottoFactory.createLottoNumbers("1, 2, 3, 4, 5, 6").get(3)).isEqualTo(new LottoNum(4));
    }
}
