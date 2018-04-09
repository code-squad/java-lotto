package lotto.view;

import lotto.domain.Numbers;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
	private static Scanner scanner = new Scanner(System.in);
	private static final String WIN_NUMBER_SPLIT_REGEX = ", |,";
	
	public static int showGetMoneyView() {
		System.out.println("구입금액을 입력해 주세요.");
		return scanner.nextInt();
	}
	
	public static Numbers showGetWinNumbersView() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		scanner.nextLine();
		return new Numbers(Arrays.stream(scanner.nextLine().split(WIN_NUMBER_SPLIT_REGEX))
				.mapToInt(Integer::parseInt)
				.toArray());
	}
}
