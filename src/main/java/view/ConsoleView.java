package view;

import model.ResultTypes;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class ConsoleView {

	private static Scanner scanner = new Scanner(System.in);

	public static int getMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		return scanner.nextInt();
	}

	public static Integer[] getLastWeekWinningCombination() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		String inputText = scanner.next();
		return Arrays.stream(inputText.split(","))
				.map(text -> Integer.valueOf(text.trim()))
				.toArray(Integer[]::new);
	}

	public static int getBonusNumber() {
		System.out.println("보너스 볼을 입력해 주세요.");
		return scanner.nextInt();
	}

	public static void printResultStatistics(Map<ResultTypes, Integer> gameResults) {
		StringBuilder stringBuilder = new StringBuilder("당첨 통계\n").append("----------\n");

		for (ResultTypes resultTypes : gameResults.keySet()) {
			stringBuilder.append(
					String.format("%d개 일치 (%d)%s - %d개\n",
							resultTypes.matchCount,
							resultTypes.prize,
							resultTypes.bonus ? ", 보너스 볼 일치" : "",
							gameResults.get(resultTypes)));
		}

		System.out.println(stringBuilder.toString());
	}

    public static void printYieldRate(long yieldRate) {
		System.out.println(String.format("총 수익률은 %d%%입니다.", yieldRate));
    }
}
