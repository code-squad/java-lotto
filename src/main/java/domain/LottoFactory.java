package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoFactory {
    public static UserLotto makeLotto() {
        return new UserLotto(makeLottoNumbers(makeNumbers()));
    }

    public static Lottos makeLottos(int lottoCount) {
        List<UserLotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(makeLotto());
        }
        return new Lottos(lottos);
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
