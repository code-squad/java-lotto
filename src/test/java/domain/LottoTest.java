package domain;

import dto.LottoDto;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class LottoTest {
    List<Integer> lotto;

    @Before
    public void setUp() {
        lotto = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            lotto.add(i);
        }
    }

    @Test
    public void makeLotto() {
        System.out.println(Lotto.init());
    }

    @Test
    public void equals1() {
        Lotto l1 = Lotto.initArtifitial(lotto);
        Lotto l2 = Lotto.initArtifitial(lotto);
        System.out.println(l1 + " " + l2);
        System.out.println(l1.equals(l2));
    }

    @Test
    public void equals2() {
        List<Integer> lottoNumbs = new ArrayList<>(lotto);
        Lotto l1 = Lotto.initArtifitial(lottoNumbs);

        for (Integer lottoNumb : lottoNumbs) {
            System.out.print(lottoNumb + " ");
        }

        System.out.println();
        Collections.shuffle(lottoNumbs);

        List<Integer> lottoNumbs2 = new ArrayList<>(lottoNumbs.size());
        for (int i : lottoNumbs) lottoNumbs2.add(i);

        for (Integer lottoNumb : lottoNumbs2) {
            System.out.print(lottoNumb + " ");
        }
        System.out.println();

        Lotto l2 = Lotto.initArtifitial(lottoNumbs2);
        System.out.println(l1 + " " + l2);
        System.out.println(l1.equals(l2));
    }

    @Test
    public void compareLottoNumbs() {
        List<Integer> numbs = new ArrayList<>(lotto);

        numbs.remove(1);
        numbs.add(7);

        Lotto l1 = Lotto.initArtifitial(numbs);
        Lotto l2 = Lotto.initArtifitial(lotto);

        assertEquals(5, l1.compareLottoNumbs(l2));
    }

}