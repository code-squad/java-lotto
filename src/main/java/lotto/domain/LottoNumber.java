package lotto.domain;

public class LottoNumber extends Number implements Comparable<LottoNumber>{
    private final int number;

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    @Override
    public int compareTo(LottoNumber anotherLottoNumber) {
        return Integer.compare(this.number, anotherLottoNumber.number);
    }

    @Override
    public int intValue() {
        return number;
    }

    @Override
    public long longValue() {
        return (long) number;
    }

    @Override
    public float floatValue() {
        return (float) number;
    }

    @Override
    public double doubleValue() {
        return (double) number;
    }

    public static LottoNumber parseLottoNumber(String s) throws NumberFormatException {
        return new LottoNumber(Integer.parseInt(s,10));
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public boolean equals(LottoNumber anotherLottoNumber) {
        return number == anotherLottoNumber.number;
    }

    private void validateNumber(int number) {
        if(!(number >= MIN_NUMBER && number <= MAX_NUMBER)) {
            throw new IllegalArgumentException("로또 번호 또는 당첨번호는 " + MIN_NUMBER + "~" + MAX_NUMBER + " 사이 값이어야 합니다.");
        }
    }
}
