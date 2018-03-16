import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Input input = new Input();
        Scanner scanner = new Scanner(System.in);
        input.inputPrice();
        int inputPrice = scanner.nextInt();
        int num = inputPrice / 1000;
        System.out.println(num + "개를 구매했습니다.");
        ArrayList<Lotto> lottos = input.makeLottos(num);
        Input.rightNumber();
        Check check = new Check();
        check.checking(lottos);
        Input.rightResult();
        Money money = new Money();
        money.money(Lotto.counts);
        ResultView.printCount(money.finalCount);
        System.out.println("총 수익률은 " + money.profit(money.totalMoney(Money.totalMoney), inputPrice) + "%입니다.");
    }
}
