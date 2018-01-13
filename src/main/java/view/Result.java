package view;

import model.Lotto;

public class Result {
    private Lotto lotto;

    public Result(int price) {
        lotto = new Lotto(price);
    }

    public void printResult() {
        System.out.printf("%d개를 구매했습니다.", lotto.countOfLotto());
    }
}
