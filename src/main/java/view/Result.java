package view;

import model.Lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private List<Lotto> lottos;
    private int price;
    private Map<Integer, Integer> winningPrice;
    private Map<Integer, Integer> winningCount;

    public Result(int price) {
        this.price = price;
        lottos = makeLotto(countOfLotto());
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
    }

    private List<Lotto> makeLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public int countOfLotto() {
        return price / 1000;
    }

    public void printResult() {
        System.out.printf("%d개를 구매했습니다.\n", countOfLotto());
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void insertLastWinningNumbers(String numbersText) {
        List<Integer> numbers = parseInts(split(numbersText));
        for (Lotto lotto : lottos) {
            int count = lotto.checkTheAnswerNumbers(numbers);
            if (winningCount.containsKey(count)) {
                winningCount.put(count, winningCount.get(count) + 1);
            }
        }
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

    public void statistics() {
        for (int i = 3; i <= 6; i++) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", i, winningPrice.get(i), winningCount.get(i));
        }
    }

    public void revenue() {
        System.out.printf("총 수익률은 %d%%입니다.", calRevenue());
    }

    private int calRevenue() {
        float max = 0;
        for(int i = 3; i <= 6; i++) {
            if(winningCount.get(i) > 0) {
                max += winningCount.get(i) * winningPrice.get(i);
            }
        }
        return Math.round(max / price * 100) - 100;
    }
}
