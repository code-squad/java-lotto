package domain;

import domain.result.LottoNum;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LottoNumTest {

    @Test(expected = IllegalArgumentException.class)
    public void 오버범위_숫자_생성자전달() {
        new LottoNum(46);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 마이너스_숫자_생성자전달() {
        new LottoNum(-1);
    }

    @Test
    public void 정상_숫자_생성자전달() {
        new LottoNum(24);
    }

    @Test
    public void 일치하는_로또번호객체인가() {
        LottoNum lottoNum1 = new LottoNum(45);
        LottoNum lottoNum2 = new LottoNum(45);
        assertTrue(lottoNum1.equals(lottoNum2));
    }

    @Test
    public void 로또번호_인스턴스_오름차순() {
        List<LottoNum> nums = Arrays.asList(new LottoNum(44), new LottoNum(6));
        Collections.sort(nums);
        assertEquals(new LottoNum(6), nums.get(0));
        assertEquals(new LottoNum(44), nums.get(1));
    }
}
