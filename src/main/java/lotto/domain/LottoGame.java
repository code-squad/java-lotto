package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class LottoGame {
	private static final int LOTTO_PRICE = 1000;
	
	int calculateLottoNumber(int money) {
		return money / LOTTO_PRICE;
	}
	
	public List<Lotto> generateLotto(int lottoNumber) {
		return IntStream.range(0, lottoNumber)
				.mapToObj(n -> Collections.shuffle(Arrays.asList(IntStream.rangeClosed(1, 45).toArray()))
				.
	}
}
