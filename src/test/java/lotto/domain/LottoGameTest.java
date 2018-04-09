package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
	private LottoGame lottoGame;
	
	@Before
	public void setUp() throws Exception {
		lottoGame = new LottoGame(new TestLottoGenerator());
		lottoGame.generateLottos(5000);
	}
	
	@Test
	public void 당첨번호123456_테스트() {
		assertThat(lottoGame.calculateProfitRate(new Numbers(1,2,3,4,5,6), 5000)).isEqualTo(500);
	}
}
