package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LottoWiningNumTest {

    @Test(expected = IllegalArgumentException.class)
    public void 범위벗어난_당첨번호_설정() {
        LottoWiningNum winingNum = new LottoWiningNum(Arrays.asList(47, 41, -1, 5, 6, 7));
    }

    @Test
    public void 정상범위_당첨번호_설정() {
        LottoWiningNum winingNum = new LottoWiningNum(Arrays.asList(9, 42, 18, 19, 2, 7));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 개수_부족한_당첨번호_설정() {
        LottoWiningNum winingNum = new LottoWiningNum(Arrays.asList(9, 42, 18, 19));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 개수_많은_당첨번호_설정() {
        LottoWiningNum winingNum = new LottoWiningNum(Arrays.asList(6, 7, 31, 9, 42, 18, 19));
    }

    @Test
    public void 정상길이_당첨번호_설정() {
        LottoWiningNum winingNum = new LottoWiningNum(Arrays.asList(9, 42, 18, 19, 2, 7));
    }
}