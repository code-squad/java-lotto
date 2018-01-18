import model.Lotto;
import model.LottoGame;
import view.ConsoleView;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		int money = ConsoleView.getMoney();
		Integer[] numbers = ConsoleView.getLastWeekWinningCombination();

		LottoGame lottoGame = new LottoGame(money);
		Lotto winningLotto = new Lotto(Arrays.asList(numbers));

		ConsoleView.printResultStatistics(lottoGame.runGames(winningLotto));
		ConsoleView.printYieldRate(lottoGame.getYieldRate());
	}
}
