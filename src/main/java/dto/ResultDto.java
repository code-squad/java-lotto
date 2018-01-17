package dto;

import domain.Lotto;
import domain.Lottos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultDto {
    private Map<Integer, Integer> winningPrice;
    private Map<Integer, Integer> winningCount;
    private int price;

    public ResultDto(int price) {
        winningPrice = new HashMap<>();
        winningPrice.put(3, 5000);
        winningPrice.put(4, 50000);
        winningPrice.put(5, 1500000);
        winningPrice.put(6, 2000000000);
        winningCount = new HashMap<>();
        winningCount.put(3, 0);
        winningCount.put(4, 0);
        winningCount.put(5, 0);
        winningCount.put(6, 0);
        this.price = price;
    }

    public Map<Integer, Integer> getWinningPrice() {
        return winningPrice;
    }

    public Map<Integer, Integer> getWinningCount() {
        return winningCount;
    }

    public int calRevenue() {
        float max = 0;
        for (int i = 3; i <= 6; i++) {
            if (winningCount.get(i) > 0) {
                max += winningCount.get(i) * winningPrice.get(i);
            }
        }
        return Math.round(max / price * 100) - 100;
    }

    public void checkLastWinningNumbers(String lastWinningNumbers, Lottos lottos) {
        Lotto numbers = new Lotto(parseInts(split(lastWinningNumbers)));
        int size = lottos.size();
        for (int i = 0; i < size; i++) {
            int count = lottos.get(i).checkTheWinningNumbers(numbers);
            if (winningCount.containsKey(count)) {
                winningCount.put(count, winningCount.get(count) + 1);
            }
        }
    }

    public int countOfLotto() {
        return price / 1000;
    }

    private String[] split(String text) {
        return text.split("(, )");
    }

    private List<Integer> parseInts(String[] numbersText) {
        List<Integer> numbers = new ArrayList<>();
        for (String numberText : numbersText) {
            int a = parseInt(numberText);
            numbers.add(a);
        }
        return numbers;
    }

    private int parseInt(String numberText) {
        return Integer.parseInt(numberText);
    }
}
