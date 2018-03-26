import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    private ArrayList<Lotto> lottos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void rightNumber() {
        System.out.println("지난주의 당첨번호를 입력해주세요.");
    }

    public static void bonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public static void rightResult() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public ArrayList<Lotto> makeLottos(int num) {
        for(int i = 0; i < num; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
            System.out.println(lotto.getLotto());
        }
        return lottos;
    }

    public String right() {
        String right = scanner.nextLine();
        return right;
    }
}
