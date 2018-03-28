package lotto;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Scanner;

public class HandLotto {
    private lotto.Lotto lotto;
    public ArrayList<lotto.Lotto> generateHandLotto(int handbuy, ArrayList<lotto.Lotto> lottos) {
=======
import java.util.List;
import java.util.Scanner;

public class HandLotto {
    private Lotto lotto;
    public List<Lotto> generateHandLotto(int handbuy, List<Lotto> lottos) {
>>>>>>> 80e6998bd7808e35b79848303683d11e08a70492
        Scanner scanner = new Scanner(System.in);
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for(int i = 0; i < handbuy; i++) {
            String str = scanner.nextLine();
            lotto = new lotto.Lotto(str);
            lottos.add(lotto);
        }
<<<<<<< HEAD
        return lottos;
    }

    public void printLottoAll(ArrayList<lotto.Lotto> lottos) {
        for(int i = 0; i < lottos.size(); i++)
            System.out.println(i + "번째 로또 " + lottos.get(i).getLotto());
=======
        printLottoAll(lottos);
        return lottos;
    }

    public void printLottoAll(List<Lotto> lottos) {
        for(int i = 0; i < lottos.size(); i++)
            System.out.println(lottos.get(i).getLotto());
>>>>>>> 80e6998bd7808e35b79848303683d11e08a70492
    }
}
