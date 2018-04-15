package lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.vo.LottoNumber;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("NonAsciiCharacters")
public class LottoTest {
    private Lotto lotto;

    @Before
    public void setUp() {
        LottoNumber lottoNumber = LottoNumber.of(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toSet()));
        lotto = Lotto.of(lottoNumber);
    }

    @Test
    public void 기본_로또_생성_랜덤_6자리_숫자() {
        Lotto lotto = Lotto.of();
        assertThat(lotto.toString().split(", ")).hasSize(6);
    }

    @Test
    public void 로또_생성_지정_6자리_숫자() {
        LottoNumber lottoNumber2 = LottoNumber.of(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toSet()));
        Lotto lotto2 = Lotto.of(lottoNumber2);
        assertThat(lotto).isEqualTo(lotto2);
    }
}
