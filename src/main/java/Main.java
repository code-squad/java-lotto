import view.Result;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        Result result = new Result(sc.nextInt());
        result.printResult();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        sc.nextLine();
        result.insertLastWinningNumbers(sc.nextLine());
        result.statistics();
        result.revenue();
    }
}
