package lotto.domain;

import java.util.List;

public class LottoNo {

	public LottoNo(int number) {
		if (isCorrectRange(number)) {
			throw new IllegalArgumentException("1~45범위의 숫자만 입력해주세요.");
		}
	}

	public static void check(List<Integer> userNum) {
		for (int i = 0; i < userNum.size(); i++) {
			new LottoNo(userNum.get(i));
		}
	}

	public static boolean isCorrectRange(int number) {
		return (number <= 0) || (number > 45);
	}

}
