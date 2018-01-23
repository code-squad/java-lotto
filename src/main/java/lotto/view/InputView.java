package lotto.view;

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

    public static int getCustomCount(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

        return scanner.nextInt();
    }

    public static List<String> getCustomNumber(int count){
        Scanner scanner = new Scanner(System.in);
        List<String> texts = new ArrayList<>();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for(int c=0 ; c<count ; c++){
            texts.add(scanner.nextLine());
        }

        return texts;
    }

    public static String getLuckyNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return scanner.nextLine();
    }

    public static int getBonus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        int number = scanner.nextInt();

        return number;
    }

}
