package lotto.domain;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int LIMIT_MIN_NUMBER = 1;
    private static final int LIMIT_MAX_NUMBER = 45;
    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if (lottoNumber < LIMIT_MIN_NUMBER || lottoNumber > LIMIT_MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(int number) {
        return new LottoNumber(number);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LottoNumber)) {
            return false;
        }

        return lottoNumber == ((LottoNumber) obj).lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber obj) {
        if (this.lottoNumber < obj.lottoNumber) {
            return -1;
        }
        if (this.lottoNumber > obj.lottoNumber) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
