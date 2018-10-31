package lotto.dto;

import lotto.domain.Money;

import java.util.Arrays;

public class InputDto {
    private Money money;
    private int numberOfLottoToBuyManually;
    private String[] enterNumbers;

    public InputDto(Money money, int numberOfLottoToBuyManually, String[] enterNumbers) {
        this.money = money;
        this.numberOfLottoToBuyManually = numberOfLottoToBuyManually;
        this.enterNumbers = enterNumbers;
    }

    public Money getMoney() {
        return money;
    }

    public int getNumberOfLottoToBuyManually() {
        return numberOfLottoToBuyManually;
    }

    public String[] getEnterNumbers() {
        return enterNumbers;
    }

    @Override
    public String toString() {
        return "InputDto{" +
                "money=" + money +
                ", numberOfLottoToBuyManually=" + numberOfLottoToBuyManually +
                ", enterNumbers=" + Arrays.toString(enterNumbers) +
                '}';
    }
}