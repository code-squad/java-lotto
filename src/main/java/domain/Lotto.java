package domain;

import dto.LottoDto;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class Lotto {
    public static final int LOTTO_NUM = 6;
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if (isInvalidNumberLength(numbers.size())) {
            throw new IllegalArgumentException("길이를 확인해주세요 (" + LOTTO_NUM + "개 입력해야함)");
        }
        this.numbers = numbers;
    }

    public static boolean isInvalidNumberLength(int length) {
        return LOTTO_NUM != length;
    }

    public LottoDto match(LottoWiningNum winningNumber) {
        int matchPoint = getMatchPoint(winningNumber);
        return convertLottoDto(matchPoint);
    }

    private LottoDto convertLottoDto(int matchPoint) {
        return new LottoDto(numbers, matchPoint);
    }

    private int getMatchPoint(LottoWiningNum winningNumber) {
        int matchPoint = 0;
        for (Integer number : numbers) {
            if (winningNumber.isMatchNumber(number)) {
                matchPoint++;
            }
        }
        return matchPoint;
    }

    @Override
    public String toString() {
        return "[" + unfoldNumbers() + "]";
    }

    private String unfoldNumbers() {
        Collections.sort(numbers);
        return numbers.stream().map(String::valueOf).collect(joining(", "));
    }
}
