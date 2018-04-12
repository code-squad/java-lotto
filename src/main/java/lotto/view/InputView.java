package lotto.view;

import lotto.domain.LottoWinNumbers;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
	private static Scanner scanner = new Scanner(System.in);
	private static final String WIN_NUMBER_SPLIT_REGEX = ", |,";
	
	public static int showGetMoneyView() {
		System.out.println("구입금액을 입력해 주세요.");
		return Integer.parseInt(scanner.nextLine());
	}
	
	public static LottoWinNumbers showGetWinNumbersView() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		int numbers[] = Arrays.stream(scanner.nextLine().split(WIN_NUMBER_SPLIT_REGEX))
				.mapToInt(Integer::parseInt)
				.toArray();
		
		System.out.println("보너스 볼을 입력해주세요.");
		int bonusNumber = Integer.parseInt(scanner.nextLine());
		
		return new LottoWinNumbers(numbers, bonusNumber);
	}
}
