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
	public void 로또생성갯수얻기_테스트() {
		assertThat(lottoGame.calculateLottoNumber(14000)).isEqualTo(14);
	}
	
	@Test
	public void 로또생성하기_테스트() {
		assertThat(lottoGame.generateLotto(13).size()).isEqualTo(13);
	}
}
