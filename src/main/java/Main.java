import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Input input = new Input();
        Scanner scanner = new Scanner(System.in);

        Input.inputPrice();
        int inputPrice = scanner.nextInt();
        int num = inputPrice / 1000;
        System.out.println(num + "개를 구매했습니다.");
        input.makeLotto(num);

        System.out.println();
        Input.rightNumber();
        String rightInput = scanner.next();
        List<String> rightNumber = Arrays.asList(rightInput.split(","));

        for(int i = 0; i < input.lottos.size(); i++) {
            input.lottos.get(i).checkNumber(rightNumber);
        }

        Input.rightResult();
        Money money = new Money();
        money.money(Lotto.counts);
        int total = money.totalMoney(money.totalMoney);
        int prof = money.profit(total , inputPrice);
        ResultView.printCount(money.finalCount);
        System.out.println("총 수익률은 " + prof + "%입니다.");
    }
}
