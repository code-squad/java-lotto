package javaLotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private List<Integer> winningNumber = new ArrayList<>();

    public WinningNumber(String winningNumber) {
        this.winningNumber = stringToList(winningNumber);
    }

    public List<Integer> stringToList(String winningNumber) {
        String[] splitNumber = winningNumber.split(",");
        for (String number : splitNumber) {
            this.winningNumber.add(Integer.parseInt(number));
        }
        return this.winningNumber;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

}
