package domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RandomLottoGeneratorTest {

    private RandomLottoNumbersGenerator generator;

    @Before
    public void setUp() throws Exception {
        generator = new RandomLottoNumbersGenerator();
    }

    @Test
    public void createRandomLottoNumbers() throws Exception {
        Lotto lotto = generator.createRandomLottoNumbers();

        assertThat(lotto).isNotNull();
    }

}