package domain;

import dto.LottoResult;

import java.util.List;

public class Lotto {
    public static final int LOTTO_NUM = 7;
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 45;
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

    // TODO : 리턴 타입 만들기
    public LottoResult match(Lotto winningNumber) {

        return null;
    }
}
