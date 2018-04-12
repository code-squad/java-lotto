package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
	private LottoGame lottoGame;
	
	@Before
	public void setUp() throws Exception {
		lottoGame = new LottoGame(new TestLottoGenerator());
	}

	@Test
	public void generateLottos테스트() {
		assertThat(lottoGame.generateLottos(4400).size()).isEqualTo(4);
	}

	@Test
	public void 당첨번호123456_테스트() {
		lottoGame.generateLottos(5000);
		assertThat(lottoGame.calculateProfitRate(new LottoWinNumbers(new Numbers(1, 2, 3, 4, 5, 6), 7), 5000)).isEqualTo(500);
	}

	@Test
	public void getResults테스트() {
		lottoGame.generateLottos(5000);
		int numbers[] = {1, 2, 3, 4, 5, 6};
		assertThat(lottoGame.getResults(new LottoWinNumbers(new Numbers(1, 2, 3, 4, 5, 6), 7)).size()).isEqualTo(LottoWinType.values().length);
	}
}
