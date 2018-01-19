package lotto.view;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static int getTotalCost(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");

        // validate
        return scanner.nextInt();
    }

    public static List<Integer> getLuckyNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String text = scanner.nextLine();

        text = text.trim();
        String[] values = text.split(",");

        return toInts(values);
    }

    public static int getBonus(List<Integer> luckyNumbers) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        int number = scanner.nextInt();

        if(luckyNumbers.contains(number)){
            throw new IllegalArgumentException("보너스 번호 입력을 잘못하였습니다.");
        }

        validateRange(number);

        return number;
    }

    private static List<Integer> toInts(String[] values){
        List<Integer> result = new ArrayList<>();

        for(int i=0 ; i<values.length ; i++){
            // validate
            result.add(toInt(values[i]));
        }

        if(result.size() < Lotto.LOTTO_PICK_COUNT){
            throw new IllegalArgumentException("당첨번호 입력을 잘못하였습니다.");
        }

        return result;
    }

    private static int toInt(String value){
        int number = Integer.parseInt(value);
        validateRange(number);

        return number;
    }

    private static void validateRange(int number){
        if(number < 0 || number > Lotto.LOTTO_MAX_NUMBER){
            throw new IllegalArgumentException("당첨번호 입력을 잘못하였습니다.");
        }
    }

}
