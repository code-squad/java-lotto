package domain;

import org.junit.Test;

public class LottoMakerTest {
    @Test
    public void generateLottoTest() {
        LottoMaker.generateLotto(5).stream()
                .forEach(System.out::println);
    }
}
