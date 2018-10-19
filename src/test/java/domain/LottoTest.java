package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import vo.No;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTest {
    List<No> lotto;

    @Before
    public void setUp() {
        lotto = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            lotto.add(new No(i));
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
        List<No> lottoNumbs = new ArrayList<>(lotto);
        Lotto l1 = Lotto.initArtifitial(lottoNumbs);

        for (No lottoNumb : lottoNumbs) {
            System.out.print(lottoNumb + " ");
        }

        System.out.println();
        Collections.shuffle(lottoNumbs);

        List<No> lottoNumbs2 = new ArrayList<>(lottoNumbs.size());
        for (No i : lottoNumbs) lottoNumbs2.add(i);

        for (No lottoNumb : lottoNumbs2) {
            System.out.print(lottoNumb + " ");
        }
        System.out.println();

        Lotto l2 = Lotto.initArtifitial(lottoNumbs2);
        System.out.println(l1 + " " + l2);
        System.out.println(l1.equals(l2));
    }

    @Test
    public void compareLottoNumbs() {
        List<No> numbs = new ArrayList<>(lotto);

        numbs.remove(1);
        numbs.add(new No(7));

        Lotto l1 = Lotto.initArtifitial(numbs);
        Lotto l2 = Lotto.initArtifitial(lotto);

        assertEquals(5, l1.compareLottoNumbs(l2));
    }

    @Test
    public void checkBonusNum() {
        No bonusNum = new No(3);
        Lotto l = Lotto.initArtifitial(lotto);
        assertEquals(true, l.checkBonusNum(bonusNum));
    }

}