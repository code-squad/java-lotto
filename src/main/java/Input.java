import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    private ArrayList<Lotto> lottos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void inputPrice() {
        System.out.println("구입금액을 입력해주세요.");
    }

    public Integer price() {
        return scanner.nextInt();
    }

    public static void rightNumber() {
        System.out.println("지난주의 당첨번호를 입력해주세요.");
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
        String right = scanner.next();
        return right;
    }
}
