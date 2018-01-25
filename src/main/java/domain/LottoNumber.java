package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumber {
    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if(lottoNumber >= 46 || lottoNumber <= 0){
            throw new IllegalArgumentException();
        }
        this.lottoNumber = lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {

        return Objects.hash(lottoNumber);
    }
}
