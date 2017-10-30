package lotto.model;

import org.junit.Test;

import lotto.model.WinningLotto;

public class WinningLottoTest {

    @Test
    public void create() {
        WinningLotto lotto = new WinningLotto("1, 2, 3, 4, 5, 6");
        System.out.println(lotto);
    }

}
