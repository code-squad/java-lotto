package model;

import org.junit.Test;

import java.util.Arrays;

public class LottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void invalidArgumentTest1() {
        new Lotto("-1,2,3,4,5,6".split(","));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidArgumentTest2() {
        new Lotto("1,2,3,4,5,56".split(","));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidArgumentTest3() {
        new Lotto("1,2,3".split(","));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidArgumentTest4() {
        new Lotto("1,1,1,1,1,1".split(","));
    }
}
