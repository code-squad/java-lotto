package model;

public class LottoNumber implements Comparable<LottoNumber> {

    private int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object obj) {
        if (!obj.getClass().equals(LottoNumber.class))
            return false;

        return this.number == ((LottoNumber)obj).number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }
}
