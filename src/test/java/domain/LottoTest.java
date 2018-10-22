package domain;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LottoTest {
    @Test
    public void create(){
        Lotto lotto = LottoFactory.generateRandomLotto();
        System.out.println(lotto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void boundaryException(){
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5));
        Lotto lotto = LottoFactory.generateTheLotto(set);
        System.out.println(lotto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void boundaryException2(){
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 46));
        Lotto lotto = LottoFactory.generateTheLotto(set);
        System.out.println(lotto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void lengthException(){
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        Lotto lotto = LottoFactory.generateTheLotto(set);
        System.out.println(lotto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bothException(){
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 46));
        Lotto lotto = LottoFactory.generateTheLotto(set);
        System.out.println(lotto);
    }

    @Test
    public void calculateHitCount(){
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lottoA = LottoFactory.generateTheLotto(set);
        Lotto lottoB = LottoFactory.generateTheLotto(set);

        assertThat(lottoA.calculateHitCount(lottoB)).isEqualTo(6);

        Set<Integer> list2 = new HashSet<Integer>(Arrays.asList(1, 2, 3, 43, 44, 45));
        Lotto lottoC = LottoFactory.generateTheLotto(list2);

        assertThat(lottoA.calculateHitCount(lottoC)).isEqualTo(3);
        assertThat(lottoC.calculateHitCount(lottoA)).isEqualTo(3);
    }







}
