package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LottoMainTest {
    List<Integer> winningNumber;

    @Before
    public void setup() {
        winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void getLastWinningNumber() {
        // getWinnerNumber()내에 system.in 대신 "1, 2, 3, 4, 5, 6" 넣으면 정상 패스
//        assertEquals(winningNumber, InputView.getWinningNumber());
    }
}
