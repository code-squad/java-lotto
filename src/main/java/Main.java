import model.LottoGame;
import model.NaturalNumber;
import model.WinningLotto;
import view.ConsoleView;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		try {
			NaturalNumber money = new NaturalNumber(ConsoleView.getMoney());
			NaturalNumber manualCount = new NaturalNumber(ConsoleView.getManualCount());

			List<List<Integer>> lottoNumbers = ConsoleView.getManualCombinations(manualCount);
			LottoGame lottoGame = new LottoGame(money, lottoNumbers);

			ConsoleView.printAllLottoNumbers(lottoGame, manualCount);

			Integer[] numbers = ConsoleView.getLastWeekWinningCombination();
			int bonus = ConsoleView.getBonusNumber();
			WinningLotto winningLotto = new WinningLotto(Arrays.asList(numbers), bonus);

			ConsoleView.printResultStatistics(lottoGame.runGames(winningLotto));

			ConsoleView.printYieldRate(lottoGame.getYieldRate());
		} catch(IllegalArgumentException e) {
			ConsoleView.printErrorMessage(e.getMessage());
			System.exit(1);
		}

	}

}
