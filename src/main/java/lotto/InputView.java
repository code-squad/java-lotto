package lotto;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class InputView {
	private static String[] input;
	private static final int NUM_MAX = 45;
	private static final int NUM_MIN = 0;

	public static int inputMoney(Scanner sc) {
		System.out.println("구입금액을 입력해 주세요.");

		return validateMoney(sc.nextInt());
	}

	private static int validateMoney(int money) {
		Scanner sc = new Scanner(System.in);
		
		if (money < 1000) {
			System.out.println("다시 입력해 주세요. 최소 금액은 1000원입니다.");
			money = sc.nextInt();
			return validateMoney(money);
		}
		return money;
	}

	public static ArrayList<Integer> inputWinNum(Scanner sc) {
		ArrayList<Integer> prizeNum = new ArrayList<>();
		try {
			System.out.println("당첨 숫자를 입력해주세요.(','로 구분)");
			input = sc.nextLine().split(",");
			prizeNum = validateArrSize(changeNumToArray(changeToInteger(input)));
		} catch (Exception e) {
			return inputWinNum(sc);
		}
		return prizeNum;
	}

	private static ArrayList<Integer> validateArrSize(ArrayList<Integer> prizeNum) {
		if (prizeNum.size() != 6)
			return inputWinNum(new Scanner(System.in));
		return prizeNum;
	}

	private static ArrayList<Integer> changeToInteger(String[] s) {
		ArrayList<Integer> prizeNum = new ArrayList<>();
		for (int i = 0; i < s.length; i++)
			prizeNum.add(Integer.parseInt(s[i]));
		return prizeNum;
	}

	private static ArrayList<Integer> changeNumToArray(ArrayList<Integer> prizeNum) {
		for (int i = 0; i < prizeNum.size(); i++)
			if (prizeNum.get(i) == NUM_MIN || prizeNum.get(i) > NUM_MAX)
				return inputWinNum(new Scanner(System.in));
		return prizeNum;

	}

}
