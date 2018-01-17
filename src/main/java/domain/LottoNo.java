package domain;

import java.util.Objects;

public class LottoNo {
    private int no;

    public LottoNo(int no) {
        inputCheck(no);

        this.no = no;
    }

    private void inputCheck(int no) {
        if(no < 0 || no > 45)
            throw new IllegalArgumentException("Invalid input for lotto number");
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
        return String.valueOf(no);
    }
}
