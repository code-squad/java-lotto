import model.Lotto;
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

			List<String> lottoNumbers = ConsoleView.getManualCombinations(manualCount);
			LottoGame lottoGame = new LottoGame(money, lottoNumbers);

			ConsoleView.printAllLottoNumbers(lottoGame, manualCount);

			String numbers = ConsoleView.getLastWeekWinningCombination();
			int bonus = ConsoleView.getBonusNumber();

			ConsoleView.printResultStatistics(lottoGame.runGames(numbers.split(","), bonus));

			ConsoleView.printYieldRate(lottoGame.getYieldRate());
		} catch(IllegalArgumentException e) {
			ConsoleView.printErrorMessage(e.getMessage());
			System.exit(1);
		}

	}

}
