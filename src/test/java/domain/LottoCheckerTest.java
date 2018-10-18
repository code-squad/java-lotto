package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoCheckerTest {
    LottoChecker lottoChecker;
    
    @Before
    public void setUp() throws Exception {
        List<Integer> winningNums = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        lottoChecker = new LottoChecker(winningNums);
    }

    @Test
    public void matchCheck() {
        assertThat(lottoChecker.matchCheck(2)).isEqualTo(1);
        assertThat(lottoChecker.matchCheck(8)).isEqualTo(0);
    }

    @Test
    public void getMatchNum() {
        assertThat(lottoChecker.getMatchNum(Arrays.asList(1,2,3,7,8,4))).isEqualTo(4);
    }
}