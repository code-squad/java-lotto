package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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

}
