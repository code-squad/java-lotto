package lotto;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static Long getInputPrice() {
        System.out.println("구입금액을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        if(userInput == null || userInput.isEmpty() || userInput.trim().isEmpty() || !StringUtils.isNumeric(userInput))
            throw new IllegalArgumentException();
        return Long.parseLong(userInput);
    }

    public static List<String> getWinNumbers(){
        List<String> winNumbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        winNumbers.add(scanner.nextLine());

        System.out.println("보너스 볼을 입력해주세요.");
        winNumbers.add(scanner.nextLine());

        return winNumbers;
    }


}
