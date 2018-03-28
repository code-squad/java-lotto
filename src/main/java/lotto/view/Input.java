package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {
	
	public static int InputPrice() {
		Scanner sc = new Scanner(System.in);
		System.out.println("구매금액을 입력해주세요.");
		return sc.nextInt();
	}

	public static List<String> inputBeforWinNum() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		List<String> beforeWinNum = Arrays.asList(sc.nextLine().split(","));
		return beforeWinNum;
	}
	
	
}
