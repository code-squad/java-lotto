package domain;

import util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    public static Lotto makeLotto() {
        return new Lotto(makeLottoNumbers(makeNumbers()));
    }

    public static Lotto makeHandLotto(String lottoNumber) {
        return new Lotto(makeHandLottoNumber(lottoNumber));
    }

    public static Lottos autoMakeLottos(int lottoCount) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(makeLotto());
        }
        return lottos;
    }

    private static List<Integer> makeHandLottoNumber(String lottoNumber) {
        return Arrays.stream(Utils.split(lottoNumber))
                .map(s -> Utils.parseInt(s))
                .collect(Collectors.toList());
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
