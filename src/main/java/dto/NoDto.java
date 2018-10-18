package dto;

import java.util.Objects;

public class NoDto {

    private int num;

    private NoDto(int num) {
        this.num = num;
    }

    public static NoDto init(int num) {
        return new NoDto(num);
    }

    public int getNum() {
        return this.num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoDto noDto = (NoDto) o;
        return num == noDto.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    @Override
    public String toString() {
        return this.num + "";
    }

}
