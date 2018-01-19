package view;

import model.LottoGame;
import model.ResultTypes;
import model.UserLotto;

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

	public static List<List<Integer>> getManualCombinations(int count) {
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");

		List<List<Integer>> lottoNumbers = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			String inputText = scanner.next();
			List<Integer> numbers = Arrays.stream(inputText.split(","))
								.map(text -> Integer.valueOf(text.trim()))
								.collect(Collectors.toList());
			lottoNumbers.add(numbers);
		}
		return lottoNumbers;
	}

	public static Integer[] getLastWeekWinningCombination() {
		System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
		String inputText = scanner.next();
		return Arrays.stream(inputText.split(","))
				.map(text -> Integer.valueOf(text.trim()))
				.toArray(Integer[]::new);
	}

	public static int getBonusNumber() {
		System.out.println("보너스 볼을 입력해 주세요.");
		return scanner.nextInt();
	}


	public static void printAllLottoNumbers(LottoGame lottoGame, int manualCount) {
		List<UserLotto> lottos = lottoGame.getLottos();
		System.out.println(String.format("수동으로 %d장, 자동으로 %d장을 구매했습니다.\n", manualCount, lottos.size() - manualCount));

		for(UserLotto lotto : lottos) {
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
}
