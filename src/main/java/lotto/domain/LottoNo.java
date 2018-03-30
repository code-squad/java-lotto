package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNo {
	private int number;

	public LottoNo(int number) {
		this.number = number;
	}

	public static void check(List<Integer> userNum) {
		List<LottoNo> lottoNos = new ArrayList<>();
		for (int i = 0; i < userNum.size(); i++) {
			lottoNos.add(new LottoNo((userNum.get(i))));
		}
		checkLottoNo(lottoNos);
	}

	public static void checkLottoNo(List<LottoNo> lottoNos) {
		for (int j = 0; j < lottoNos.size(); j++) {
			check(lottoNos, j);
		}
	}

	public static void check(List<LottoNo> lottoNos, int i) {
		if (lottoNos.get(i).isCorrectRange()) {
			throw new IllegalArgumentException("1~45범위의 숫자만 입력해주세요.");
		}
		if (i < lottoNos.size() - 1 && lottoNos.get(i).isSameNo(lottoNos.get(i + 1))) {
			throw new IllegalArgumentException("중복되는 숫자는 입력할 수 없습니다.");
		}
		if (lottoNos.size() != 6) {
			throw new IndexOutOfBoundsException("6개의 숫자를 입력해주세요.");
		}
	}

	public boolean isCorrectRange() {
		return (number <= 0) || (number > 45);
	}

	public boolean isSameNo(LottoNo anotherNo) {
		return number == anotherNo.number;
	}
}
