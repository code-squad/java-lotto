package domain;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import java.util.List;

public class LottoTest {
    @Test
    public void create(){
        Lotto lotto = LottoFactory.generateRandomLotto();
        System.out.println(lotto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void boundaryException(){
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5);
        Lotto lotto = LottoFactory.generateTheLotto(list);
        System.out.println(lotto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void boundaryException2(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 46);
        Lotto lotto = LottoFactory.generateTheLotto(list);
        System.out.println(lotto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void lengthException(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Lotto lotto = LottoFactory.generateTheLotto(list);
        System.out.println(lotto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bothException(){
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 46);
        Lotto lotto = LottoFactory.generateTheLotto(list);
        System.out.println(lotto);
    }

    @Test
    public void calculateHitCount(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lottoA = LottoFactory.generateTheLotto(list);
        Lotto lottoB = LottoFactory.generateTheLotto(list);

        assertThat(lottoA.calculateHitCount(lottoB)).isEqualTo(6);

        List<Integer> list2 = Arrays.asList(1, 2, 3, 43, 44, 45);
        Lotto lottoC = LottoFactory.generateTheLotto(list2);

        assertThat(lottoA.calculateHitCount(lottoC)).isEqualTo(3);
        assertThat(lottoC.calculateHitCount(lottoA)).isEqualTo(3);
    }







}
