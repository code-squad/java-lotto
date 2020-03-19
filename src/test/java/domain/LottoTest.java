package domain;

import org.junit.Before;
import org.junit.Test;
import vo.LottoNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private List<LottoNumber> lottoNumbers;

    @Before
    public void setUp() throws Exception {
        lottoNumbers = new ArrayList<>(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5)
        ));
    }

    @Test
    public void 로또생성() {
        lottoNumbers.add(new LottoNumber(6));

        new Lotto(lottoNumbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또생성_중복번호존재() {
        lottoNumbers.add(new LottoNumber(5));

        new Lotto(lottoNumbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또생성_사이즈6개미만() {
        new Lotto(lottoNumbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또생성_사이즈6개초과() {
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(6));
        lottoNumbers.add(new LottoNumber(7));

        new Lotto(lottoNumbers);
    }

    @Test
    public void 로또번호_다른로또와_일치개수확인() {
        //given
        List<LottoNumber> oneDiffLottoNumbers = new ArrayList<>(lottoNumbers);
        List<LottoNumber> allDiffLottoNumbers = new ArrayList<>();

        oneDiffLottoNumbers.add(new LottoNumber(7));
        for (int i = 10; i < 16; i++) {
            allDiffLottoNumbers.add(new LottoNumber(i));
        }
        lottoNumbers.add(new LottoNumber(6));

        Lotto myLotto = new Lotto(lottoNumbers);
        Lotto sameLotto = new Lotto(lottoNumbers);
        Lotto oneDiffLotto = new Lotto(oneDiffLottoNumbers);
        Lotto allDiffLotto = new Lotto(allDiffLottoNumbers);

        //when
        int count6 = myLotto.countNumberOfMatch(sameLotto);
        int count5 = myLotto.countNumberOfMatch(oneDiffLotto);
        int count0 = myLotto.countNumberOfMatch(allDiffLotto);

        //then
        assertThat(count6).isEqualTo(6);
        assertThat(count5).isEqualTo(5);
        assertThat(count0).isEqualTo(0);
    }

    @Test
    public void 보너스숫자존재유무 () {
        //when
        lottoNumbers.add(new LottoNumber(6));
        Lotto lotto = new Lotto(lottoNumbers);
        LottoNumber bonusNumber6 = new LottoNumber(6);
        LottoNumber bonusNumber7 = new LottoNumber(7);

        //then
        boolean hasBonus6 = lotto.hasBonusNumber(bonusNumber6);
        boolean hasBonus7 = lotto.hasBonusNumber(bonusNumber7);

        assertThat(hasBonus6).isTrue();
        assertThat(hasBonus7).isFalse();
    }
}
