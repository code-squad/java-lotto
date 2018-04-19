package Lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber implements Comparable<LottoNumber> {

    public static Map<Integer, LottoNumber> lottoNumber;

    static {
        lottoNumber = new HashMap<>();
        for (int i = 1; i < 46; i++) {
            lottoNumber.put(i, new LottoNumber(i));
        }
    }

    private int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber getLottoNumber(Integer number) {
        return lottoNumber.get(checkLottoNumberRange(number));
    }

    public static LottoNumber getLottoNumber(String number) {
        return lottoNumber.get(checkLottoNumberRange(stringToInteger(number.trim())));
    }

    private static Integer stringToInteger(String number) {
        return Integer.valueOf(number);
    }

    private static Integer checkLottoNumberRange(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
        return number;
    }

    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber lottoNumber = (LottoNumber) o;
        return number == lottoNumber.number;
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return this.number - lottoNumber.number;
    }
}