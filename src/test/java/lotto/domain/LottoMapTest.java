package lotto.domain;

import org.junit.Test;

public class LottoMapTest {
    @Test
    public void getTest() {
        LottoMap map = new LottoMap();
        map.saveCountWinLotto(3);
        map.saveCountWinLotto(3);
        System.out.println(map.getMap());
    }
}
