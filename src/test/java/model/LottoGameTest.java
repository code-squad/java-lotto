package model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

	@Test
	public void generateAllAutoGame() {
		LottoGame lottoGame = new LottoGame(14000);
		assertThat(lottoGame.getLottos().size()).isEqualTo(14);
	}

	@Test
	public void getWinners() {
		LottoGame lottoGame = new LottoGame(14000);
		Lotto winningLotto = new Lotto(46, 6, Arrays.asList(1, 2, 3, 4, 5, 6));
		lottoGame.setWinningLotto(winningLotto);
	}

}
