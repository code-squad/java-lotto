package lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.vo.BonusNumber;
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
        LottoNumber lottoNumber = LottoNumber.of(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toSet()));
        Lotto lotto = Lotto.of(lottoNumber);
        BonusNumber bonusNumber = BonusNumber.of(7);
        winningLotto = new WinningLotto(lotto, bonusNumber);
    }

    @Test
    public void 로또번호_3개_이상_매치시_5등_Rank_Enum_반환() {
        LottoNumber lottoNumber = LottoNumber.of(Stream.of(1, 2, 3, 10, 11, 12).collect(Collectors.toSet()));
        Lotto lotto = Lotto.of(lottoNumber);

        Rank rank = winningLotto.rank(lotto);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    public void 로또번호_6개_이상_매치시_1등_Rank_Enum_반환() {
        LottoNumber lottoNumber = LottoNumber.of(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toSet()));
        Lotto lotto = Lotto.of(lottoNumber);

        Rank rank = winningLotto.rank(lotto);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }
}
