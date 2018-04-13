package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLottoGeneratorTest {
	private RandomLottoGenerator randomLottoGenerator;
	
	@Before
	public void setUp() throws Exception {
		randomLottoGenerator = new RandomLottoGenerator();
	}
	
	@Test
	public void generate테스트() {
		assertThat(randomLottoGenerator.generate(0).size())
				.isEqualTo(0);
	}
}
