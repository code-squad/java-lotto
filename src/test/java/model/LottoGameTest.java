package model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

	private LottoGame lottoGame;
	private WinningLotto winningLotto;

	@Before
	public void setup() {
		List<List<Integer>> myLottos = new ArrayList<>();
		myLottos.add(Arrays.asList(1,2,3,4,5,16));
		myLottos.add(Arrays.asList(1,2,3,4,15,17));
		myLottos.add(Arrays.asList(1,2,3,4,15,18));
		myLottos.add(Arrays.asList(1,2,3,14,15,19));
		myLottos.add(Arrays.asList(1,2,13,14,15,20));

		lottoGame = new LottoGame(5000, myLottos);

		winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 27);
	}

	@Test
	public void generateAllAutoGame() {
		lottoGame = new LottoGame(5000);
		assertThat(lottoGame.getLottos().size()).isEqualTo(5);
	}

	@Test
	public void getWinners() {
		Map<ResultTypes, Integer> result = lottoGame.runGames(winningLotto);
		assertThat(result.size()).isEqualTo(4);
		assertThat(result.keySet()).contains(ResultTypes.NO_MATCH);
		assertThat(result.keySet()).contains(ResultTypes.MATCH3);
		assertThat(result.keySet()).contains(ResultTypes.MATCH4);
		assertThat(result.keySet()).contains(ResultTypes.MATCH5);
		assertThat(result.keySet()).doesNotContain(ResultTypes.MATCH6);
		assertThat(result.get(ResultTypes.NO_MATCH)).isEqualTo(1);
		assertThat(result.get(ResultTypes.MATCH3)).isEqualTo(1);
		assertThat(result.get(ResultTypes.MATCH4)).isEqualTo(2);
		assertThat(result.get(ResultTypes.MATCH5)).isEqualTo(1);
		assertThat(result.get(ResultTypes.MATCH6)).isEqualTo(null);
	}

	@Test
	public void getYieldRate() {
		lottoGame.runGames(winningLotto);
		long yieldRate = lottoGame.getYieldRate();

		assertThat(yieldRate).isEqualTo(32100);
	}
}
