package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuyLotto {
    private List<Lotto> lottos;

    public BuyLotto(int inputMoney) {
        lottos = new ArrayList<>();
        int num = inputMoney / 1000;
        for(int i = 0; i < num; i++)
            lottos.add(new Lotto());
    }

    public List<Lotto> manualBuy(int manualBuy) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("수동으로 구매할 번호를 입력하시오.");
        for(int i = 0; i < manualBuy; i++)
            lottos.add(new Lotto(scanner.nextLine()));
        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
