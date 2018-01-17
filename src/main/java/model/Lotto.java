package model;

import lombok.Getter;

import java.util.List;

@Getter
public class Lotto {

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

}
