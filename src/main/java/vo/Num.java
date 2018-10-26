package vo;

import java.util.Objects;

public class Num implements Comparable<Num> {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private int number;

    public Num(int number) {
        this.number = checkNumber(number);
    }

    private int checkNumber(int number) {
        if (number < MIN || number > MAX)
            throw new IllegalArgumentException();
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Num)) return false;
        Num number1 = (Num) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "" + number;
    }

    @Override
    public int compareTo(Num num) {
        if (this.number > num.number)
            return 1;
        else if (this.number < num.number)
            return -1;
        else
            return 0;
    }
}
