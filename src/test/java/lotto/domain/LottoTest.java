package lotto.domain;


import org.junit.Test;
import java.util.*;
import java.util.ArrayList;

public class LottoTest {

    @Test
    public void 비교() {
        /*
        Lotto lotto = new Lotto();
        Lotto winLotto = new Lotto("1,2,3,4,5,6");
        System.out.println(lotto);
        System.out.println(winLotto);
        System.out.println(lotto.compare(winLotto));
        */
    }

    @Test
    public void subList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        System.out.println(list.subList(0,3));

    }

    @Test
    public void generateLotto() {
        Lotto lotto = Lotto.generateLottoNumber();
        System.out.println(lotto);
    }

    @Test
    public void winningLotto() {
        Lotto lotto = Lotto.winningLotto("1,2,3,4,5,6");
        System.out.println(lotto);
    }
}
