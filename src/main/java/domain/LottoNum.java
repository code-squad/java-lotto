package domain;

import java.util.Objects;

public class LottoNum implements Comparable<LottoNum> {
    public static final int MIN = 1;
    public static final int MAX = 45;
    private int num;

    public LottoNum(int num) {
        if (isInvalidNum(num)) {
            throw new IllegalArgumentException("로또 번호 범위 : " + MIN + "이상 " + MAX + "이하");
        }
        this.num = num;
    }

    private static boolean isInvalidNum(int num) {
        return num < MIN || num > MAX;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNum lottoNum = (LottoNum) o;
        return num == lottoNum.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }

    @Override
    public int compareTo(LottoNum otherNum) {
        return this.num - otherNum.num;
    }
}
