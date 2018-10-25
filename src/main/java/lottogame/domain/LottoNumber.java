package lottogame.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {
    public static final Integer MAXIMUM_LOTTO_NUM = 46;
    private static Map<Integer, LottoNumber> map = new HashMap<>();
    private final Integer num;

    private LottoNumber(Integer num) {
        if (num < 1 || num > MAXIMUM_LOTTO_NUM) {
            throw new IllegalArgumentException("로또의 숫자는 1~46입니다.");
        }
        this.num = num;
    }

    public static LottoNumber Of(Integer num) {
        if (map.containsKey(num)) {
            return map.get(num);
        }
        LottoNumber lottoNumber = new LottoNumber(num);
        map.put(num, lottoNumber);
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return num.equals(that.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    @Override
    public String toString() {
        return num.toString();
    }

}
