package lotto.view;

import lotto.domain.Lotto;

import java.util.Scanner;

public class InputView {

    public static int getTotalCost(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static int[] getLuckyNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String text = scanner.nextLine();

        text = text.replace(" ", "");
        String[] values = text.split(",");

        return toInts(values);
    }

    private static int[] toInts(String[] values){
        int[] result = new int[values.length];

        for(int i=0 ; i<values.length ; i++){
            result[i] = Integer.parseInt(values[i]);
        }

        return result;
    }
}
