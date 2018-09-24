package Lotto;

import Lotto.Exception.OutOfRangeLottoNumberException;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber implements Comparable<LottoNumber> {

    public static Map<Integer, LottoNumber> lottoNumbers;

    static {
        lottoNumbers = new HashMap<>();
        for (int i = 1; i < 46; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber getLottoNumber(Integer number) {
        return lottoNumbers.get(checkLottoNumberRange(number));
    }

    public static LottoNumber getLottoNumber(String number) throws IllegalArgumentException {
        return lottoNumbers.get(checkLottoNumberRange(stringToInteger(number.trim())));
    }

    private static Integer stringToInteger(String number) {
        return Integer.valueOf(number);
    }

    public static Integer checkLottoNumberRange(Integer number) {
        if (number < 1 || number > 45) {
            throw new OutOfRangeLottoNumberException();
        }
        return number;
    }

    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LottoNumber lottoNumber = (LottoNumber) o;
        return number == lottoNumber.number;
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return this.number - lottoNumber.number;
    }

}