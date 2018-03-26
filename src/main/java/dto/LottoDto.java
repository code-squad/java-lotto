package dto;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class LottoDto {
    private List<Integer> numbers;
    private int matchPoint;

    public LottoDto(List<Integer> numbers, int matchPoint) {
        this.numbers = numbers;
        this.matchPoint = matchPoint;
    }

    public int getMatchPoint() {
        return matchPoint;
    }

    @Override
    public String toString() {
        return "[" + "numbers=" + unfoldNumbers() + ']';
    }

    private String unfoldNumbers() {
        Collections.sort(numbers);
        return numbers.stream().map(String::valueOf).collect(joining(", "));
    }

    public boolean isMatchPoint(int matchPoint) {
        return this.matchPoint == matchPoint;
    }
}
