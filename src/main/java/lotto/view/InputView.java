package lotto.view;

import java.util.Scanner;

public class InputView {
    public int requestToInputTicketTotalPrice() {
        System.out.println("로또 1장의 가격은 1000원이다.");
        System.out.println("구입금액을 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String requestToInputLastWeekSuccessNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
