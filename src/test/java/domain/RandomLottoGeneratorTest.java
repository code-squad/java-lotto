package domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RandomLottoGeneratorTest {

    private RandomLottoGenerator generator;

    @Before
    public void setUp() throws Exception {
        generator = new RandomLottoGenerator();
    }

    @Test
    public void createRandomLotto() throws Exception {
        Lotto lotto = generator.createRandomLotto();

        assertThat(lotto).isNotNull();
    }

}