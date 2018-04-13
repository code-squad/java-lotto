package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
	private LottoGame lottoGame;
	
	@Before
	public void setUp() throws Exception {
		lottoGame = new LottoGame(new TestLottoGenerator());
	}

	@Test
	public void generateLottos_정상테스트() {
		List<Lotto> customLottos = new ArrayList<>();
		customLottos.add(new Lotto(new LottoNumbers(1, 2, 3, 4, 5, 6), false));
		customLottos.add(new Lotto(new LottoNumbers(7, 8, 9, 10, 11, 12), false));
		assertThat(lottoGame.generateLottos(4400, customLottos)
				.size())
				.isEqualTo(4);
	}
	
	@Test
	public void generateLottos_customeLotto로모두생성테스트() {
		List<Lotto> customLottos = new ArrayList<>();
		customLottos.add(new Lotto(new LottoNumbers(1, 2, 3, 4, 5, 6), false));
		customLottos.add(new Lotto(new LottoNumbers(7, 8, 9, 10, 11, 12), false));
		assertThat(lottoGame.generateLottos(2000, customLottos)
				.size())
				.isEqualTo(2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void generateLottos_Null예외테스트() {
		lottoGame.generateLottos(4400, null);
	}
	
	@Test
	public void 당첨번호123456_테스트() {
		lottoGame.generateLottos(5000);
		assertThat(lottoGame.calculateProfitRate(new LottoWinNumbers(new LottoNumbers(1, 2, 3, 4, 5, 6), new LottoNumber(7)), 5000))
				.isEqualTo(500);
	}

	@Test
	public void getResults테스트() {
		lottoGame.generateLottos(5000);
		int numbers[] = {1, 2, 3, 4, 5, 6};
		assertThat(lottoGame.getResults(new LottoWinNumbers(new LottoNumbers(1, 2, 3, 4, 5, 6), new LottoNumber(7)))
				.size())
				.isEqualTo(LottoWinType.values().length);
	}
}
