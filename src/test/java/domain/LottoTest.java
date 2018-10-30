package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTest {
    private Lotto lotto;

    @Before
    public void setUp() {
        List<LottoNum> lottoNums = new ArrayList<>();
        for(int i = 1; i <= Lotto.LOTTO_NUMBER_COUNT; i++) {
            lottoNums.add(new LottoNum(i));
        }
        lotto = new Lotto(lottoNums);
    }

    @Test
    public void isContainLottoNumTest() {
        assertThat(lotto.isContainLottoNum(new LottoNum(1))).isTrue();
        assertThat(lotto.isContainLottoNum(new LottoNum(9))).isFalse();
    }

    @Test
    public void getLottoNumTest() {
        assertThat(lotto.getLottoNum(2)).isEqualTo(new LottoNum(3));
    }

    @Test
    public void createHandOperatedLottoTest() {
        assertThat(LottoFactory.createHandOperatedLotto("1, 2, 3, 4, 5, 6")).isEqualTo(lotto);
    }

    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        Collections.shuffle(list);
        for(int num : list) {
            System.out.print(num + "\t");
        }
        System.out.println();

        Collections.shuffle(list);
        for(int num : list) {
            System.out.print(num + "\t");
        }
        System.out.println();
        Collections.shuffle(list);
        for(int num : list) {
            System.out.print(num + "\t");
        }
        System.out.println();
        Collections.shuffle(list);
        for(int num : list) {
            System.out.print(num + "\t");
        }
    }

    @Test
    public void test2() {
        Set<LottoNum> set = new TreeSet<>();
        set.add(new LottoNum(5));
        set.add(new LottoNum(3));
        set.add(new LottoNum(1));
        System.out.println(set.toString());
    }

    @Test
    public void test3() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        for(String num : list.subList(0, 3)) {
            System.out.print(num + "\t");
        }
        System.out.println();

        List<String> subList = list.subList(0, 3);
        subList.remove(1);
        for(String num : subList) {
            System.out.print(num + "\t");
        }

        System.out.println();
        for(String s : list) {
            System.out.print(s + "\t");
        }
    }
}
