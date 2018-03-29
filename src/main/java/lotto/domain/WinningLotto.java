package lotto.domain;

import java.util.Collections;
import java.util.List;

public class WinningLotto extends Lotto {

	public WinningLotto(List<Integer> numbers) {
		super.numbers = numbers;
	}

	public static WinningLotto of(List<Integer> numberRange) {
		Collections.shuffle(numberRange);
		return new WinningLotto(makeLottoNum(numberRange));
	}

}
