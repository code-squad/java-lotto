package javaLotto.view;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);
    public static String setPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        return checkPrice(scanner.nextLine());
    }

    public static String setWinningNumber(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String setBonusNumber(){
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }

    private static String checkPrice(String inputPrice) {
        if(inputPrice == null || inputPrice.isEmpty()){
            throw new IllegalArgumentException("exception");
        }
        return inputPrice;
    }

}
