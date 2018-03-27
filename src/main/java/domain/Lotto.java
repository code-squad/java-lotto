package domain;

import dto.LottoDto;

import java.util.Arrays;
import java.util.List;

public abstract class Lotto {
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 45;
    public static final int LOTTO_NUM = 6;
    private NormalNumber normalNumber;

    Lotto(List<Integer> numbers) {
        if (!LottoNum.isExistLottoNum(numbers.size())) {
            throw new IllegalArgumentException("숫자 개수가 부족합니다.");
        }

        if (isIncludeOutRange(numbers)) {
            throw new IllegalArgumentException("범위를 벗어난 숫자가 포함되어있습니다.");
        }
        initNumbers(numbers);
        normalNumber = new NormalNumber(numbers);
    }

    private static boolean isIncludeOutRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(number -> number < MIN_NUM || number > MAX_NUM);
    }

    void initNumbers(List<Integer> numbers) {
        int normalIdxRange = LOTTO_NUM - 1;
        normalNumber = new NormalNumber(numbers.subList(0, normalIdxRange));
    }

    public LottoDto match(Lotto lotto) {
        NormalNumber otherNumbers = lotto.normalNumber;
        int matchCount = normalNumber.calcMatchCount(otherNumbers);
        return new LottoDto(normalNumber, matchCount);
    }

    @Override
    public String toString() {
        return "[" + normalNumber.unfoldNumbers() + "]";
    }
}

enum LottoNum {
    USER(Lotto.LOTTO_NUM),
    WINNING(WinningLotto.LOTTO_NUM);

    private int lottoNum;

    LottoNum(int lottoNum) {
        this.lottoNum = lottoNum;
    }

    public static boolean isExistLottoNum(int lottoLength) {
        return Arrays.stream(LottoNum.values()).anyMatch(lottoType -> lottoType.lottoNum == lottoLength);
    }
}
