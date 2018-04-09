package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTestGameTest {
	private LottoGame lottoGame;
	
	@Before
	public void setUp() throws Exception {
		lottoGame = new LottoGame();
	}
	
	@Test
	public void 당첨번호123456_테스트() {
		assertThat(lottoGame.play(5000)).isEqualTo(500);
	}
}
