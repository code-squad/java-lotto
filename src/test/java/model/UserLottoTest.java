package model;

import org.junit.Test;

import java.util.Arrays;

public class UserLottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void invalidArgumentTest1() {
        new UserLotto(Arrays.asList(-1,2,3,4,5,6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidArgumentTest2() {
        new UserLotto(Arrays.asList(1,2,3,4,5,56));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidArgumentTest3() {
        new UserLotto(Arrays.asList(1,2,3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidArgumentTest4() {
        new UserLotto(Arrays.asList(1,1,1,1,1,1));
    }
}
