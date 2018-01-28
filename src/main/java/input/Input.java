package input;

import java.util.Optional;
import java.util.Scanner;

public class Input {

    private Input() {
    }

    public static Input of(){
        return new Input();
    }

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Optional.of(new Scanner(System.in).nextInt()).orElse(0);
        } catch (Exception e) {
            return 0;
        }
    }

    public String inputLastWeekWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        try {
            return Optional.ofNullable(new Scanner(System.in).nextLine()).orElseThrow(NullPointerException::new);
        } catch (Exception e) {
            return "";
        }
    }

    public int insertBonusball() {
        System.out.println("보너스 볼을 입력하세요.");
        try {
            return Optional.of(new Scanner(System.in).nextInt()).orElse(0);
        } catch (Exception e) {
            return 0;
        }
    }

    public int inputManualBuyNumber() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        try {
            return Optional.of(new Scanner(System.in).nextInt()).orElse(0);
        } catch (Exception e) {
            return 0;
        }
    }

    public void printManualNumberMessage(){
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public String inputManualNumber() {
        try {
            return Optional.ofNullable(new Scanner(System.in).nextLine()).orElseThrow(NullPointerException::new);
        } catch (Exception e) {
            return "";
        }
    }
}
