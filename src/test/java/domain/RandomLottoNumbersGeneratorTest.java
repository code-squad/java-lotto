package domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RandomLottoNumbersGeneratorTest {

    private RandomLottoNumbersGenerator generator;

    @Before
    public void setUp() throws Exception {
        generator = new RandomLottoNumbersGenerator();
    }

    @Test
    public void createRandomLottoNumbers() throws Exception {
        LottoNumbers lottoNumbers = generator.createRandomLottoNumbers();

        assertThat(lottoNumbers).isNotNull();
    }

}