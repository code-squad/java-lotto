package domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBundleTest {
    @Test
    public void create(){
        LottoBundle theLottoBundle1 = LottoBundleFactory.generateRandomLottoBundle(0);
        LottoBundle theLottoBundle2 = LottoBundleFactory.generateRandomLottoBundle(1);
        LottoBundle theLottoBundle3 = LottoBundleFactory.generateRandomLottoBundle(2);
        LottoBundle theLottoBundle4 = LottoBundleFactory.generateRandomLottoBundle(3);
    }

    @Test
    public void calculateWinStats(){
        LottoBundle theLottoBundle1 = LottoBundleFactory.generateRandomLottoBundle(0);
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6);
        List<Integer> list2 = Arrays.asList(1,2,3,4,5,7);
        List<Integer> list3 = Arrays.asList(1,2,3,4,8,9);
        List<Integer> list4 = Arrays.asList(43, 44, 1, 2, 3, 4);
        Lotto lottoA = LottoFactory.generateTheLotto(list1);
        Lotto lottoB = LottoFactory.generateTheLotto(list2);
        Lotto lottoC = LottoFactory.generateTheLotto(list3);
        Lotto lottoD = LottoFactory.generateTheLotto(list4);

        theLottoBundle1.add(lottoA);
        theLottoBundle1.add(lottoB);
        theLottoBundle1.add(lottoC);
        theLottoBundle1.add(lottoD);

        Lotto answer = LottoFactory.generateTheLotto(list1);
        int[] arr = theLottoBundle1.calculateWinStats(answer);
        assertThat(arr[6]).isEqualTo(1);
        assertThat(arr[5]).isEqualTo(1);
        assertThat(arr[4]).isEqualTo(2);
        assertThat(arr[3]).isEqualTo(0);
        assertThat(arr[2]).isEqualTo(0);
        assertThat(arr[1]).isEqualTo(0);
        assertThat(arr[0]).isEqualTo(0);
    }
}
