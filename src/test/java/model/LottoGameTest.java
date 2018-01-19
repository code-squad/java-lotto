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
	private String[] winningLottoNumbers;
	private int bonus;

	@Before
	public void setup() {
		List<String> myLottos = new ArrayList<>();
		myLottos.add("1,2,3,4,5,16");
		myLottos.add("1,2,3,4,15,17");
		myLottos.add("1,2,3,4,15,18");
		myLottos.add("1,2,3,14,15,19");
		myLottos.add("1,2,13,14,15,20");

		lottoGame = new LottoGame(new NaturalNumber(5000),myLottos);

		winningLottoNumbers = "1,2,3,4,5,6".split(",");
		bonus = 27;
	}

	@Test
	public void generateAllAutoGame() {
		lottoGame = new LottoGame(new NaturalNumber(5000));
		assertThat(lottoGame.getLottos().size()).isEqualTo(5);
	}

	@Test
	public void getWinners() {
		Map<ResultTypes,Integer> result = lottoGame.runGames(winningLottoNumbers, bonus);
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
		lottoGame.runGames(winningLottoNumbers, bonus);
		long yieldRate = lottoGame.getYieldRate();

		assertThat(yieldRate).isEqualTo(32100);
	}

	@Test(expected=IllegalArgumentException.class)
	public void NotEnoughMoneyException() {
		new LottoGame(new NaturalNumber(1), Arrays.asList("1,2,3,4,5,6"));
	}
}
