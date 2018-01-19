import model.*;
import view.ConsoleView;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		try {
			LottoCredit credit = new LottoCredit(ConsoleView.getMoney());
			NaturalNumber manualCount = new NaturalNumber(ConsoleView.getManualCount());

			List<String> lottoNumbers = ConsoleView.getManualCombinations(manualCount);
			LottoGame lottoGame = new LottoGame(credit, lottoNumbers);

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
