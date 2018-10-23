package domain;

import java.util.Objects;

public class LottoNum implements Comparable<LottoNum> {
    private int num;

    private LottoNum(int num) {
        if (num > 45 || num < 1) {
            throw new IllegalArgumentException("로또번호가 잘못됬습니다.");
        }
        this.num = num;
    }


    public static LottoNum stringCreate(String no) {
        int num = Integer.parseInt(no);
        return new LottoNum(num);
    }


    public static LottoNum intCreate(int no) {
        return new LottoNum(no);
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
    public int compareTo(LottoNum o) {
        return Integer.compare(this.num, o.num);
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }
}
