package view;

import domain.LottoNo;
import domain.LottoNoGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static domain.LottoUtils.inputParser;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int enterUserMoney() {
        try {
            System.out.println("구입할 금액을 넣어주세요.");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해 주세요.");
            return enterUserMoney();
        }
    }

    public static LottoNo enterBonusBall() {
        try {
            System.out.println("보너스 볼을 뽑아주세요.");
            return LottoNo.of(Integer.parseInt(scanner.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해 주세요.");
            return enterBonusBall();
        }
    }

    public static LottoNoGroup enterWinningLotto() {
        try {
            System.out.println("지난 주 당첨 번호를 입력해 주세요. 구분자 (\",\")");
            return inputParser(scanner.nextLine().trim());
        } catch (InputMismatchException e) {
            System.out.println("올바른 값을 입력해 주세요.");
            return enterWinningLotto();
        }
    }

    public static int enterNumManualTickets() {
        try {
            System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해 주세요.");
            return enterNumManualTickets();
        }
    }

    public static List<LottoNoGroup> enterNumsOfManualTicket(int numManual) throws IOException {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<LottoNoGroup> manualInput = new ArrayList<>();
        for (int i = 0; i < numManual; i++) {
            manualInput.add(inputParser(br.readLine().trim()));
        }
        return manualInput;
    }

}
