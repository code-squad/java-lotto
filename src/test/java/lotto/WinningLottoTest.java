package lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.vo.LottoNumber;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("NonAsciiCharacters")
public class WinningLottoTest {

    WinningLotto winningLotto;

    @Before
    public void setUp() {
        Lotto lotto = Lotto.of(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList()));
        LottoNumber bonusNumber = LottoNumber.of(7);
        winningLotto = new WinningLotto(lotto, bonusNumber);
    }

    @Test
    public void 로또번호_3개_이상_매치시_5등_Rank_Enum_반환() {
        Lotto lotto = Lotto.of(Stream.of(1, 2, 3, 10, 11, 12).collect(Collectors.toList()));

        Rank rank = winningLotto.rank(lotto);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    public void 로또번호_6개_이상_매치시_1등_Rank_Enum_반환() {
        Lotto lotto = Lotto.of(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList()));

        Rank rank = winningLotto.rank(lotto);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }
}
