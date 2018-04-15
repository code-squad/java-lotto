package javaLotto.domain;

import java.util.Objects;

public class LottoNo {
    private final int no;

    public LottoNo(int no) {
        if(no < 1  || no > 45){
            throw new IllegalArgumentException("1~45만 로또번호에 포함될 수 있습니다.");
        }
        this.no = no;
    }

    public static LottoNo of(int number) {
        return new LottoNo(number);
    }

    public int getNo() {
        return no;
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
    public String toString() {
        return "LottoNo{" +
                "no=" + no +
                '}';
    }
}
