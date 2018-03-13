import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        ArrayList<Lotto> lottos = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해주세요.");
        int inputPrice = scanner.nextInt();
        int num = inputPrice / 1000;
        System.out.println(num + "개를 구매했습니다.");

        for(int i = 0; i < num; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
            lotto.printLotto();
            System.out.println();
        }

        System.out.println();
        System.out.println("지난주의 당첨번호를 입력해주세요.");
        String rightInput = scanner.next();
        List<String> rightNumber = Arrays.asList(rightInput.split(","));
        for(int i = 0; i < lottos.size(); i++) {
            lottos.get(i).checkNumber(rightNumber);
        }

        System.out.println("당첨 통계");
        System.out.println("---------");
        Money money = new Money();
        money.money(Lotto.counts);
        int total = money.totalMoney(money.totalMoney);
        System.out.println("벌어들인 금액 : "  + total);
        int prof = money.profit(total ,inputPrice);
        System.out.println("총 수익률은 " + prof + "%입니다.");
    }
}
