package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoFactory {
    public static Lotto makeLotto() {
        return new Lotto(makeLottoNumbers(makeNumbers()));
    }

    public static List<Lotto> makeLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(makeLotto());
        }
        return lottos;
    }

    private static List<Integer> makeNumbers() {
        List<Integer> numbers = new ArrayList<>();
        IntStream.range(1, 46).forEach(i -> numbers.add(i));
        return numbers;
    }

    private static List<Integer> makeLottoNumbers(List<Integer> numbers) {
        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }
}
