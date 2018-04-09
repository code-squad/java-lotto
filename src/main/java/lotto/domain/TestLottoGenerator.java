package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class TestLottoGenerator implements LottoGenerator {
	public List<Lotto> generate(int number) {
		return IntStream.range(0, number)
				.mapToObj(n -> new Lotto(1,3,5,14,22,45))
				.collect(toList());
	}
}
