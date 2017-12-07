package lotto;

import java.util.ArrayList;
import java.util.Scanner;

public class InputView {
	public static int inputMoney(Scanner sc) {
		System.out.println("구입금액을 입력해 주세요.");
		return sc.nextInt();
	}

	public static ArrayList<Integer> inputWinNum(Scanner sc2) {
		System.out.println("당첨 숫자를 입력해주세요");

		return changeInput(sc2.nextLine().split(","));
	}

	public static ArrayList<Integer> changeInput(String[] s) {
		ArrayList<Integer> winNum = new ArrayList<>();
		for (int i = 0; i < s.length; i++) {
			winNum.add(Integer.parseInt(s[i]));
		}
		return winNum;
	}

}
