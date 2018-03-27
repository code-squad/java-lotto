package domain;

import dto.LottoDto;

import java.util.Arrays;
import java.util.List;

public abstract class Lotto {
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 45;
    private NormalNumber normalNumber;

    Lotto(List<Integer> numbers) {
        if (!LottoNum.isValidLottoNum(numbers.size())) {
            throw new IllegalArgumentException("숫자 개수가 부족합니다.");
        }

        if (isIncludeOutRange(numbers)) {
            throw new IllegalArgumentException("범위를 벗어난 숫자가 포함되어있습니다.");
        }
        initNumbers(numbers);
    }

    public static Lotto of(List<Integer> numbers) {
        if (LottoNum.isWinningLotto(numbers.size())) {
            return new WinningLotto(numbers);
        }
        return new UserLotto(numbers);
    }

    private static boolean isIncludeOutRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(number -> number < MIN_NUM || number > MAX_NUM);
    }

    void initNumbers(List<Integer> numbers) {
        int normalIdxRange = UserLotto.LOTTO_NUM;
        normalNumber = new NormalNumber(numbers.subList(0, normalIdxRange));
    }

    public LottoDto match(Lotto lotto) {
        NormalNumber otherNumbers = lotto.normalNumber;
        int matchCount = normalNumber.calcMatchCount(otherNumbers);
        return new LottoDto(normalNumber, matchCount);
    }

    public boolean isContainNumber(int number) {
        return normalNumber.isContainNumber(number);
    }

    @Override
    public String toString() {
        return "[" + normalNumber.unfoldNumbers() + "]";
    }
}

enum LottoNum {
    USER(UserLotto.LOTTO_NUM),
    WINNING(WinningLotto.LOTTO_NUM);

    private int lottoNum;

    LottoNum(int lottoNum) {
        this.lottoNum = lottoNum;
    }

    public static boolean isValidLottoNum(int lottoLength) {
        return Arrays.stream(LottoNum.values()).anyMatch(lottoType -> lottoType.lottoNum == lottoLength);
    }

    public static boolean isWinningLotto(int lottoLength) {
        return WINNING.lottoNum == lottoLength;
    }
}
