package lottogame.util;

import org.junit.Test;

public class LottoRandomTest {
    @Test
    public void generate() {
        for (int i = 0; i < 10; i++) {
            System.out.println(new LottoRandom().generate());
        }
    }
}
