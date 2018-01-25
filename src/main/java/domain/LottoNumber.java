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

    public boolean contains(List<LottoNumber> lotto) {
        for(LottoNumber lottoNumber : lotto){
            if(lottoNumber.isMatch(this.lottoNumber)){
                return true;
            }
        }
        return false;
    }

    private boolean isMatch(int lottoNumber) {
        if(this.lottoNumber == lottoNumber){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return ""+lottoNumber;
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
