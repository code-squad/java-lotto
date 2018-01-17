package domain;

/**
 * Created by hoon on 2018. 1. 13..
 */
public class Ticket {

    private Numbers numbers;
    private Integer hits = 0;

    public Ticket(Numbers numbers) {
        this.numbers = numbers;
    }

    public Numbers getNumbers() {
        return numbers;
    }

    public Integer getHits() {
        return hits;
    }

    public Integer calculateHits(Numbers winningNumbers) {
        winningNumbers.sort();
        numbers.sort();
        hits = numbers.calculateHits(winningNumbers);
        return hits;
    }
}
