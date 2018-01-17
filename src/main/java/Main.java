import model.Lotto;
import model.LottoGame;
import view.ConsoleView;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		int money = ConsoleView.getMoney();
		Integer[] numbers = ConsoleView.getLastWeekWinningCombination();

		LottoGame lottoGame = new LottoGame(money);
		lottoGame.setWinningLotto(new Lotto(46, 6, Arrays.asList(numbers)));

		ConsoleView.printResultStatistics(lottoGame.runGames());
		ConsoleView.printYieldRate(lottoGame.getYieldRate());
	}
}
