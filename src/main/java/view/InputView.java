package view;

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

    public static Integer scanBonusNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼 번호를 입력해 주세요");
        return scanner.nextInt();
    }

    public static Integer scanNotAutomaticLottoNum() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("수동으로 입력할 로또의 개수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static String[] scanLottoNumbers(Integer numberOfInput){
        Scanner scanner = new Scanner(System.in);
        System.out.println("로또를 수동으로 입력해 주세요.");
        String[] input = new String[numberOfInput];

        for (int i = 0; i < numberOfInput; i++) {
            input[i] = scanner.nextLine();
        }

        return input;
    }
}
