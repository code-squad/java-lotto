package input;

import java.util.Optional;
import java.util.Scanner;

public class Input {
    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Optional.of(new Scanner(System.in).nextInt()).orElse(0);
        }catch (Exception e){
            return 0;
        }
    }

    public String inputLastWeekWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        try {
            return Optional.ofNullable(new Scanner(System.in).nextLine()).orElseThrow(NullPointerException::new);
        }catch (Exception e){
            return "";
        }
    }

    public int insertBonusball(){
        System.out.println("보너스 볼을 입력하세요.");
        try {
            return Optional.of(new Scanner(System.in).nextInt()).orElse(0);
        }catch (Exception e){
            return 0;
        }
    }
}
