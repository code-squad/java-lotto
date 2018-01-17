package model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

	LottoGame lottoGame;

	@Before
	public void setup() {
		lottoGame = new LottoGame(1000, 14000);
	}

	@Test
	public void generateGame() {
		assertThat(lottoGame.getLottos().size()).isEqualTo(14);
	}

	@Test
	public void getWinners() {
		Lotto winningLotto = new Lotto(46, 6, Arrays.asList(1, 2, 3, 4, 5, 6));
		lottoGame.setWinningLotto(winningLotto);
	}

}
