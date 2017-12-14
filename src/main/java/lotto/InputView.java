package lotto;

import java.util.ArrayList;
import java.util.Scanner;

public class InputView {

	private static final int NUM_MAX = 45;
	private static final int NUM_MIN = 0;

	public static int inputMoney(Scanner sc) {
		System.out.println("구입금액을 입력해 주세요.");
		return validateMoney(sc);
	}

	private static int validateMoney(Scanner sc) {
		int money = sc.nextInt();
		sc.reset();
		if (money < 1000) {
			System.out.println("다시 입력해 주세요. 최소 금액은 1000원입니다.");
			return validateMoney(sc);
		}
		return money;
	}

	public static ArrayList<Integer> inputUserLotto(Scanner sc) {
		System.out.println("수동으로 구매할 번호를 입력해주세요. ");
		ArrayList<Integer> userLotto = new ArrayList<>();
		sc.nextLine();

		while (sc.hasNextLine()) {
			String input = sc.nextLine();
			if (input.equals(""))
				break;
			makeUserLotto(input, userLotto);
		}
		return userLotto;
	}

	private static void makeUserLotto(String input, ArrayList<Integer> userLotto) {
		String[] user = input.split(",");
		for (int i = 0; i < user.length; i++)
			userLotto.add(Integer.parseInt(user[i]));
	}

	public static ArrayList<Integer> inputWinNum(Scanner sc) {
		ArrayList<Integer> prizeNum = new ArrayList<>();
		try {
			sc.reset();
			System.out.println("당첨 숫자를 입력해주세요.(','로 구분)");
			prizeNum = validateArrSize(changeNumToArray(changeToInteger(sc)));
		} catch (Exception e) {
			return inputWinNum(sc);
		}
		return prizeNum;
	}

	public static int inputBonus(Scanner sc) {
		System.out.println("보너스 볼을 입력해주세요.");
		return sc.nextInt();
	}

	private static ArrayList<Integer> validateArrSize(ArrayList<Integer> prizeNum) {
		if (prizeNum.size() != 6) {
			System.out.println("당첨 번호는 6개 입력하셔야 합니다.");
			return inputWinNum(new Scanner(System.in));
		}
		return prizeNum;
	}

	private static ArrayList<Integer> changeToInteger(Scanner sc) {
		ArrayList<Integer> prizeNum = new ArrayList<>();
		String[] input = sc.nextLine().split(",");
		for (int i = 0; i < input.length; i++)
			prizeNum.add(Integer.parseInt(input[i]));
		return prizeNum;
	}

	private static ArrayList<Integer> changeNumToArray(ArrayList<Integer> prizeNum) {
		for (int i = 0; i < prizeNum.size(); i++)
			if (prizeNum.get(i) == NUM_MIN || prizeNum.get(i) > NUM_MAX) {
				System.out.println("숫자의 범위를 초과하셨습니다.");
				return inputWinNum(new Scanner(System.in));
			}
		return prizeNum;

	}

}
