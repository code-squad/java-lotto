package lotto;

import static spark.Spark.get;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InputView {

	private static final int NUM_MAX = 45;
	private static final int NUM_MIN = 0;
	private static final Logger log = LoggerFactory.getLogger(LottoGame.class);

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

	public static ArrayList<MyLotto> makeUserLotto(String lotto) {
		ArrayList<MyLotto> userLottos = new ArrayList<>();
		
		String[] users = lotto.split("\n");
		for (String lottoNum : users) {
			String[] user = lottoNum.split(",");
			ArrayList<Integer> userLotto = new ArrayList<>();
			for (String num : user) {
				userLotto.add(Integer.parseInt(num.trim()));
			}
			userLottos.add(new MyLotto(userLotto));
		}
		return userLottos;
	}

	public static String inputWinNum(String winLotto) {
		if(changeNumToArray(winLotto) && validateArrSize(winLotto))
			return winLotto;
		return null;
	}

	public static int inputBonus(Scanner sc) {
		System.out.println("보너스 볼을 입력해주세요.");
		return sc.nextInt();
	}

	private static boolean validateArrSize(String winLotto) {
		if (winLotto.split(",").length != 6) {
			return false;
		}
		return true;
	}

	private static boolean changeNumToArray(String winLotto) {
		String[] input = winLotto.split(",");
		for (int i = 0; i < input.length; i++)
			if (Integer.parseInt(input[i]) == NUM_MIN || Integer.parseInt(input[i]) > NUM_MAX) {
				return false;
			}
		return true;

	}

}
