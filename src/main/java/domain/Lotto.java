package domain;

import dto.LottoDto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.joining;

public class Lotto {
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 45;
    public static final int LOTTO_NUM = 6;
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if (isInvalidNumberLength(numbers.size())) {
            throw new IllegalArgumentException("길이를 확인해주세요 (" + LOTTO_NUM + "개 입력해야함)");
        }

        if (isIncludeOutRange(numbers)) {
            throw new IllegalArgumentException("범위를 벗어난 숫자가 포함되어있습니다.");
        }
        this.numbers = numbers;
    }

    private static boolean isInvalidNumberLength(int length) {
        return LOTTO_NUM != length;
    }

    private static boolean isIncludeOutRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(number -> number < MIN_NUM || number > MAX_NUM);
    }

    public LottoDto match(Lotto winningNumber) {
        int matchPoint = getMatchPoint(winningNumber);
        return convertLottoDto(matchPoint);
    }

    private LottoDto convertLottoDto(int matchPoint) {
        return new LottoDto(numbers, matchPoint);
    }

    private int getMatchPoint(Lotto winningNumber) {
        List<Integer> winningNumbers = winningNumber.numbers;
        int fullLength = winningNumbers.size() + numbers.size();
        Set<Integer> numberPot = new HashSet<>(numbers);
        numberPot.addAll(winningNumbers);
        return fullLength - numberPot.size();
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
