package domain;

import org.junit.Test;

import static utils.LottoGameValues.LOTTO_SIZE;

public class LottoGameTest {

    @Test
    public void checkLotto() {
        int[] matchPoint = new int[LOTTO_SIZE + 1];
        matchPoint[1]++;
        System.out.println(matchPoint[1]);
        System.out.println(matchPoint[3]);
    }
}