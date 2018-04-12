package lotto.domain;

import java.util.List;
import java.util.function.Predicate;

class LottoNumbersValidator {
    private final static int LOTTO_NUMBERS = 6;
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 45; 
    
    private final static String WRONG_LOTTO_NUMBER_COUNT_MSG = "로또 번호는 6개를 선택해야 합니다.";
    private final static String WRONG_LOTTO_NUMBER_RANGE_MSG = "각각의 로또 번호는 1과 45 사이입니다.";
    private final static String LOTTO_NUMBER_DUPLICATED_MSG = "각각의 로또 번호는 중복 될 수 없습니다.";

    private LottoNumbersValidator() { }

    static void validate(List<Integer> numbers) {
        hasSixNumber(numbers);
        hasValidateRangeNumber(numbers);
        noDuplicated(numbers);
    }

    private static void hasSixNumber(List<Integer> numbers) {
        test(WRONG_LOTTO_NUMBER_COUNT_MSG, numbers, (list) -> list.size() == LOTTO_NUMBERS);
    }

    private static void hasValidateRangeNumber(List<Integer> numbers) {
        test(WRONG_LOTTO_NUMBER_RANGE_MSG, numbers, (list) -> list.stream().allMatch(i -> i >= MIN_NUMBER && i <= MAX_NUMBER));
    }

    private static void noDuplicated(List<Integer> numbers) {
        test(LOTTO_NUMBER_DUPLICATED_MSG, numbers, (list) -> list.stream().distinct().count() == LOTTO_NUMBERS);
    }

    private static void test(String message, List<Integer> numbers, Predicate<List<Integer>> validator) {
        if (!validator.test(numbers)) {
            throw new IllegalArgumentException(message);
        }
    }
}
