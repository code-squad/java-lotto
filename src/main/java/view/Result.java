package view;

import model.Lotto;

import java.util.ArrayList;
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
}
