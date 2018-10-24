package domain;

import dto.StrikeDto;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LottoCheckerTest {
    LottoChecker lottoChecker;

    @Before
    public void setUp() throws Exception {
        lottoChecker = new LottoChecker(new WinningLotto(Arrays.asList(1,2,3,4,5,6), 7));
    }

    @Test
    public void checkLotto1() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,7,9));
        assertThat(lottoChecker.checkLotto(lotto)).isEqualTo(new StrikeDto(4, true));
    }

    @Test
    public void checkLotto2() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,13,14,17,19));
        assertThat(lottoChecker.checkLotto(lotto)).isEqualTo(new StrikeDto(2, false));
    }
}