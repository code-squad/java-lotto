package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lotto.domain.UserLotto;
import lotto.domain.Lotto;

public class Input {

	public static List<Lotto> inputUserNum(String inputManualNumber) {
		List<String> manualNumber = Arrays.asList(inputManualNumber.split("\r?\n"));
		List<Lotto> userLottos = new ArrayList<>();
		for (int i = 0; i < manualNumber.size(); i++) {
			List<String> temp = Arrays.asList(manualNumber.get(i).split(","));
			userLottos.add(UserLotto.of(temp));
		}
		return userLottos;
	}

	public static UserLotto beforeWinNum(String beforeWinNumber) {
		List<String> beforeWinNum = Arrays.asList(beforeWinNumber.split(","));
		UserLotto beforeWinLotto = UserLotto.of(beforeWinNum);
		return beforeWinLotto;
	}

	public static int checkSheets(String price) {
		return Integer.parseInt(price) / 1000;
	}

}
