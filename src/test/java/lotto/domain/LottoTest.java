package lotto.domain;


import org.junit.Test;
import java.util.*;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void subList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        List<Integer> a = new ArrayList<>();
        a.add(0);
        a.add(1);
        a.add(2);
        assertThat(list.subList(0,3)).isEqualTo(a);
    }

    @Test
    public void generateLotto() {
        Lotto lotto = Lotto.generateLottoNumber();
    }

    @Test
    public void winningLotto보너스중복x() {
        Lotto lotto = Lotto.winningLotto("1,2,3,4,5,6");
        assertThat(lotto.isContainBonusNumber(7)).isFalse();
    }

    @Test
    public void winningLotto보너스중복o() {
        Lotto lotto = Lotto.winningLotto("1,2,3,4,5,6");
        assertThat(lotto.isContainBonusNumber(1)).isTrue();
    }
}
