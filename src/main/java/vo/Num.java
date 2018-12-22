package vo;

import java.util.Objects;

public class Num implements Comparable<Num> {
    public static final int MAX_NUM = 45;
    public static final int MIN_NUM = 1;

    private int num;

    public Num(int num) {
        if (num > MAX_NUM || num < MIN_NUM) throw new IllegalArgumentException();
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Num)) return false;
        Num num1 = (Num) o;
        return num == num1.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    @Override
    public String toString() {
        return num + "";
    }

    @Override
    public int compareTo(Num o) {
        if (this.num == o.num) return 0;
        if (this.num > o.num) return 1;
        return -1;
    }


}