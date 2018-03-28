package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HandLotto {
    private Lotto lotto;
    public List<Lotto> generateHandLotto(int handbuy, List<Lotto> lottos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for(int i = 0; i < handbuy; i++) {
            String str = scanner.nextLine();
            lotto = new lotto.Lotto(str);
            lottos.add(lotto);
        }
        printLottoAll(lottos);
        return lottos;
    }

    public void printLottoAll(List<Lotto> lottos) {
        for(int i = 0; i < lottos.size(); i++)
            System.out.println(lottos.get(i).getLotto());
    }
}
