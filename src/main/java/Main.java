import model.LottoGame;
import model.WinningLotto;
import view.ConsoleView;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		int money = ConsoleView.getMoney();
        LottoGame lottoGame = new LottoGame(money);
        ConsoleView.printAllLottoNumbers(lottoGame);

        Integer[] numbers = ConsoleView.getLastWeekWinningCombination();
		int bonus = ConsoleView.getBonusNumber();
		WinningLotto winningLotto = new WinningLotto(Arrays.asList(numbers), bonus);

		ConsoleView.printResultStatistics(lottoGame.runGames(winningLotto));
		ConsoleView.printYieldRate(lottoGame.getYieldRate());
	}
}
