package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoFactory {
    public static List<Lotto> lottos = new ArrayList<>();

    public static void makeLotto() {
        lottos.add(new Lotto(makeLottoNumbers(makeNumbers())));
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
