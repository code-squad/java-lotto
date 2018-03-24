package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void 길이_오버_인스턴스_생성() {
        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 길이_부족_인스턴스_생성() {
        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void 정상_길이_인스턴스_생성() {
        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 범위_오버_인스턴스_생성() {
        new Lotto(Arrays.asList(1, 2, 3, 46, 5, 6, 7));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 범위_미달_인스턴스_생성() {
        new Lotto(Arrays.asList(1, -5, 3, 0, 5, 6, 7));
    }

    @Test
    public void 정상_범위_인스턴스_생성() {
        new Lotto(Arrays.asList(1, 45, 3, 27, 5, 6, 7));
    }
}