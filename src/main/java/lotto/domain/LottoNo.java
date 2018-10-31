package lotto.domain;

import java.util.Objects;

public class LottoNo implements Comparable<LottoNo> {
    // Lotto 클래스에서 sort 를 하기위해서는 Comparable<LottoNo> 이 필요

    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;
    private final int no;

    private LottoNo(int no) {
        if(no < LOTTO_MIN || no > LOTTO_MAX){
            throw new IllegalArgumentException("숫자의 범위를 벗어납니다.");
        }
        this.no = no;
    }

    public static LottoNo of(String value){
        if(value == null){
            throw new IllegalArgumentException("값은 null을 가질 수 없습니다.");
        }
        return new LottoNo(Integer.parseInt(value.trim()));
    }

    public static LottoNo of(int number){
        return new LottoNo(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo = (LottoNo) o;
        return no == lottoNo.no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(no);
    }

    @Override
    public int compareTo(LottoNo o) {
        return no - o.no; // 오름차순
    }

    @Override
    public String toString() {
        return no + "";
    }
}
