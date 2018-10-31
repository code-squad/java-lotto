package lotto.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LottoNoTest {
    List<LottoNo> lotto = new ArrayList<>();

    @Test(expected = IllegalArgumentException.class)
    public void 자료형정상범위값() {
        lotto.add(LottoNo.of(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 자료형범위초과값() {
        lotto.add(LottoNo.of(100));
    }
}