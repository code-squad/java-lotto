package domain;

import dto.NoDto;

import java.util.Objects;

public class No implements Comparable<No> {

    public static final int MAX_NUM = 45;
    public static final int MIN_NUM = 1;

    private int num;

    private No(int num) throws IllegalArgumentException {
        this.num = checkNo(num);
    }

    public static No initString(String num) throws IllegalArgumentException {
        return new No(Integer.parseInt(num));
    }

    public static No initInt(int num) throws IllegalArgumentException {
        return new No(num);
    }

    private static int checkNo(int num) {
        if (num < MIN_NUM || MAX_NUM < num)
            throw new IllegalArgumentException("잘못된 범위의 숫자가 입력되었습니다.");
        return num;
    }

    public NoDto toDto() {
        return NoDto.init(this.num);
    }

    @Override
    public int compareTo(No o) {
        if (this.num < o.num)
            return -1;
        if (this.num == o.num)
            return 0;
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        No no = (No) o;
        return num == no.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

}
