package javaLotto.view;

import java.util.Scanner;

public class InputView {
    public static String setPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return checkPrice(scanner.nextLine());
    }

    public static String setWinningNumber(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static String checkPrice(String inputPrice) {
        if(inputPrice == null || inputPrice.isEmpty()){
            throw new IllegalArgumentException("exception");
        }
        return inputPrice;
    }

}
