package vo;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumTest {

    @Test(expected = IllegalArgumentException.class)
    public void MIN미만에러발생() {
        new Num(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void MAX초과에러발생() {
        new Num(46);
    }

    @Test
    public void 정상범위작동() {
        for (int i = 1; i < 46; i++) {
            new Num(i);
        }
    }
}
