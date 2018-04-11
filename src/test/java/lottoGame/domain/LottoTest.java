package lottoGame.domain;

import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTest {

    @Test
    public void 당첨번호확인테스트() {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(12);
        array.add(4);
        array.add(24);
        array.add(6);
        Lotto lotto = new Lotto(array);

        assertThat(lotto.isContainLuckyNum(1)).isTrue();
        assertThat(lotto.isContainLuckyNum(2)).isTrue();
        assertThat(lotto.isContainLuckyNum(10)).isFalse();
    }

    @Test
    public void 당첨번호카운트세기테스트() {

        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(10);
        array.add(4);
        array.add(24);
        array.add(6);
        Lotto lotto = new Lotto(array);

        int[] tempLuckyNums = {1,4,5,24,6,11};
        int[] tempLuckyNums2 = {1,2,30,40,50,6};

        assertThat(lotto.getSameLuckNumCnt(tempLuckyNums)).isEqualTo(4);
        assertThat(lotto.getSameLuckNumCnt(tempLuckyNums2)).isEqualTo(3);
    }
}