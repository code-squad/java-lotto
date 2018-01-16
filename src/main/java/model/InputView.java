package model;

import java.util.Scanner;

public class InputView {

    public static Integer scanMoneyToBuy(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입 금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static String scanLastWeekLottoNumbers(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난주 당청 번호를 입력해 주세요.");
        return scanner.nextLine();
    }
}
