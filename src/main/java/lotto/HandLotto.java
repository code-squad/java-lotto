package lotto;

import java.util.ArrayList;
import java.util.Scanner;

public class HandLotto {
    private lotto.Lotto lotto;
    public ArrayList<lotto.Lotto> generateHandLotto(int handbuy, ArrayList<lotto.Lotto> lottos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for(int i = 0; i < handbuy; i++) {
            String str = scanner.nextLine();
            lotto = new lotto.Lotto(str);
            System.out.println("HandLotto에서 생성된 로또" + lotto.getLotto());
            lottos.add(lotto);
        }
        return lottos;
    }

    public void printLottoAll(ArrayList<lotto.Lotto> lottos) {
        for(int i = 0; i < lottos.size(); i++)
            System.out.println(i + "번째 로또 " + lottos.get(i).getLotto());
    }
}
