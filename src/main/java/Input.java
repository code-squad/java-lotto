import java.util.ArrayList;

public class Input {
    static ArrayList<Lotto> lottos = new ArrayList<>();

    public static void inputPrice() {
        System.out.println("구입금액을 입력해주세요.");
    }

    public static void rightNumber() {
        System.out.println("지난주의 당첨번호를 입력해주세요.");
    }

    public static void rightResult() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public void makeLotto(int num) {
        for(int i = 0; i < num; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
            System.out.println(lotto.getLotto());
        }
    }
}
