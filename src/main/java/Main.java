import model.LottoGame;
import model.ResultTypes;
import model.WinningLotto;
import view.ConsoleView;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		int money = ConsoleView.getMoney();
		int manualCount = ConsoleView.getManualCount();

		List<List<Integer>> lottoNumbers = ConsoleView.getManualCombinations(manualCount);
        LottoGame lottoGame = new LottoGame(money, lottoNumbers);
        ConsoleView.printAllLottoNumbers(lottoGame, manualCount);

        Integer[] numbers = ConsoleView.getLastWeekWinningCombination();
		int bonus = ConsoleView.getBonusNumber();
		WinningLotto winningLotto = new WinningLotto(Arrays.asList(numbers), bonus);

		ConsoleView.printResultStatistics(lottoGame.runGames(winningLotto));
		ConsoleView.printYieldRate(lottoGame.getYieldRate());
	}
}
