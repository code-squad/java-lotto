package model;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int BOUND = 46;

    private int number;

    public LottoNumber(String number) throws IllegalArgumentException {
        this(Integer.parseInt(number));
    }

    public LottoNumber(int number) throws IllegalArgumentException {
        if (number <= 0 || number >= BOUND)
            throw new IllegalArgumentException("Invalid lotto number.");
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
