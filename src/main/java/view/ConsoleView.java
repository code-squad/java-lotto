package view;

import model.LottoGame;
import model.NaturalNumber;
import model.ResultTypes;
import model.Lotto;

import java.util.*;
import java.util.stream.Collectors;

public class ConsoleView {

	private static Scanner scanner = new Scanner(System.in);

	public static int getMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		return scanner.nextInt();
	}

	public static int getManualCount() {
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		return scanner.nextInt();
	}

	public static List<String> getManualCombinations(NaturalNumber count) {
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");

		List<String> lottoNumbers = new ArrayList<>();
		for (int i = 0; i < count.getNumber(); i++) {
			lottoNumbers.add(scanner.next());
		}
		return lottoNumbers;
	}

	public static String getLastWeekWinningCombination() {
		System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
		return scanner.next();
	}

	public static int getBonusNumber() {
		System.out.println("보너스 볼을 입력해 주세요.");
		return scanner.nextInt();
	}


	public static void printAllLottoNumbers(LottoGame lottoGame, NaturalNumber manualCount) {
		List<Lotto> lottos = lottoGame.getLottos();
		System.out.println(String.format("수동으로 %s장, 자동으로 %d장을 구매했습니다.\n",
				manualCount,
				lottos.size() - manualCount.getNumber()));

		for(Lotto lotto : lottos) {
			System.out.println(lotto.toString());
		}
	}

	public static void printResultStatistics(Map<ResultTypes, Integer> gameResults) {
		StringBuilder stringBuilder = new StringBuilder("당첨 통계\n").append("----------\n");

		for (ResultTypes type : gameResults.keySet()) {
			stringBuilder.append(
					String.format("%d개 일치 (%d)%s - %d개\n",
							type.getMatchCount(),
							type.getPrize(),
							type.isBonus() ? ", 보너스 볼 일치" : "",
							gameResults.get(type)));
		}

		System.out.println(stringBuilder.toString());
	}

    public static void printYieldRate(long yieldRate) {
		System.out.println(String.format("총 수익률은 %d%%입니다.", yieldRate));
    }

    public static void printErrorMessage(String message) {
		System.err.println(message);
	}
}
