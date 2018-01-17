import model.Lotto;
import model.LottoGame;
import view.ConsoleView;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		int money = ConsoleView.getMoney();
		Integer[] numbers = ConsoleView.getLastWeekWinningCombination();

		List<Integer>[] lottoNumbers = new List[1];
		lottoNumbers[0] = Arrays.asList(numbers);

		LottoGame lottoGame = new LottoGame(money, lottoNumbers);
		lottoGame.setWinningLotto(new Lotto(46, 6, Arrays.asList(numbers)));

		ConsoleView.printResultStatistics(lottoGame.runGames());
	}
}
