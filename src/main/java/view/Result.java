package view;

import model.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Result {
    private List<Lotto> lottos;
    private int price;

    public Result(int price) {
        this.price = price;
        lottos = makeLotto(countOfLotto());
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
            System.out.println(lotto.checkTheAnswerNumbers(numbers));
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
}
