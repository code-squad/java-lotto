package domain.lotto;

public class LottoNumber implements Comparable<LottoNumber> {
    private Integer number;

    public LottoNumber(Integer number) {
        this.number = number;
    }

    public LottoNumber(String number) {
        this.number = Integer.parseInt(number);
    }

    public LottoNumber(LottoNumber lottoNumber) {
        this.number = lottoNumber.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoNumber that = (LottoNumber) o;

        return number != null ? number.equals(that.number) : that.number == null;
    }

    @Override
    public int hashCode() {
        return number != null ? number.hashCode() : 0;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }
}
