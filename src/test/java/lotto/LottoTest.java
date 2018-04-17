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
        lotto = Lotto.of(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList()));
    }

    @Test
    public void 기본_로또_생성_랜덤_6자리_숫자() {
        Lotto lotto = Lotto.of();
        System.out.println(lotto.toString());
        assertThat(lotto.toString().split(", ")).hasSize(6);
    }

    @Test
    public void 로또_생성_지정_6자리_숫자() {
        Lotto lotto2 = Lotto.of(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList()));
        assertThat(lotto).isEqualTo(lotto2);
    }


    @Test(expected = IllegalArgumentException.class)
    public void 로또넘버_생성시_숫자_6개_미만_또는_초과이면_예외() {
        Lotto.of(Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList()));
        Lotto.of(Stream.of(1, 2, 3, 4, 5, 6, 7).collect(Collectors.toList()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호중_중복된_번호가_있다면_예외() {
        Lotto.of(Stream.of(1, 2, 3, 3, 5, 6).collect(Collectors.toList()));
    }

    @Test
    public void 동치성_테스트() {
        Lotto lotto1 = Lotto.of(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList()));
        Lotto lotto2 = Lotto.of(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList()));

        assertThat(lotto1).isEqualTo(lotto2);
    }

    @Test
    public void 로또번호_일치_6개() {
        Lotto lotto1 = Lotto.of(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList()));
        Lotto lotto2 = Lotto.of(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList()));

        assertThat(lotto1.matchCount(lotto2)).isEqualTo(6);
    }

    @Test
    public void 로또번호_일치_1개() {
        Lotto lotto1 = Lotto.of(Stream.of(1, 12, 13, 14, 15, 16).collect(Collectors.toList()));
        Lotto lotto2 = Lotto.of(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList()));

        assertThat(lotto1.matchCount(lotto2)).isEqualTo(1);
    }

    @Test
    public void 보너스_번호_일치() {
        Lotto lotto = Lotto.of(Stream.of(1, 12, 13, 14, 15, 16).collect(Collectors.toList()));
        assertThat(lotto.matchBonus(LottoNumber.of(16))).isTrue();
    }
}
