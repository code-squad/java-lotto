import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Input input = new Input();
        Scanner scanner = new Scanner(System.in);
        // 금액
        input.inputPrice();
        int inputPrice = Integer.parseInt(scanner.nextLine());
//        int inputPrice = scanner.nextInt();
        int num = inputPrice / 1000;
        System.out.println(num + "개를 구매했습니다.");
        ArrayList<Lotto> lottos = input.makeLottos(num);
        // 당첨번호입력
        Input.rightNumber();
        Check check = new Check();
        check.checking(lottos);
        String bonusNum = scanner.nextLine();
        // 당첨통계
        Input.rightResult();
        Money money = new Money();
//        money.money(Lotto.counts);
        Decision decision = new Decision();
        decision.addRank(check.rightNumber, lottos, bonusNum);
        money.money(decision.ranks);
        ResultView.printCount(money.finalCount);
        System.out.println("총 수익률은 " + money.profit(money.totalMoney(Money.totalMoney), inputPrice) + "%입니다.");
        decision.printRanks();

    }
}
