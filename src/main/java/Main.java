import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Input input = new Input();
        Scanner scanner = new Scanner(System.in);
        input.inputPrice();
        int inputPrice = Integer.parseInt(scanner.nextLine());
        int num = inputPrice / 1000;
        System.out.println(num + "개를 구매했습니다.");
        ArrayList<Lotto> lottos = input.makeLottos(num);
        Input.rightNumber();
        Check check = new Check();
        check.checking(lottos);
        String bonusNum = scanner.nextLine();
        Input.rightResult();
        Money money = new Money();
        Decision decision = new Decision();
        decision.addRank(check.right, lottos, bonusNum);
        money.money(decision.ranks);
        ResultView.printCount(money.finalCount);
        System.out.println("총 수익률은 " + money.profit(money.totalMoney(decision.ranks), inputPrice) + "%입니다.");
    }
}
