package domain;

import domain.result.LottoResult;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class LottoTest {
    private Lotto userLotto;
    private Lotto winningLotto;

    @Before
    public void setUp() throws Exception {
        userLotto = new Lotto(Arrays.asList(2, 19, 21, 45, 1, 13));
        winningLotto = new Lotto(Arrays.asList(9, 42, 18, 19, 2, 7));
    }

    @Test
    public void 매치포인트() {
        LottoResult dto = userLotto.match(winningLotto);
        assertEquals(2, dto.getMatchPoint());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 길이_오버_인스턴스_생성() {
        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 길이_부족_인스턴스_생성() {
        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void 정상_길이_인스턴스_생성() {
        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 범위_오버_인스턴스_생성() {
        new Lotto(Arrays.asList(1, 2, 3, 46, 5, 6, 7));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 범위_미달_인스턴스_생성() {
        new Lotto(Arrays.asList(1, -5, 3, 0, 5, 6, 7));
    }

    @Test
    public void 정상_범위_인스턴스_생성() {
        new Lotto(Arrays.asList(1, 45, 3, 27, 5, 6, 7));
    }
}