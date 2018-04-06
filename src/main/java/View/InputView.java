package View;

import domain.LottoNo;
import domain.LottoTicket;

import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final int TICKET_PRICE = 1000;
    private static Scanner scanner;

    public static int getPayment() throws Exception {
        try {
            scanner = new Scanner(System.in);
            System.out.println("구매금액을 입력해주세요.");
            return scanner.nextInt();
        }catch (Exception e) {
            throw new Exception("구매금액을 확인해 주세요. 1000원이상 숫자만 가능합니다.");
        }
    }

    public static int getManualCount() throws Exception {
        try {
            scanner = new Scanner(System.in);
            System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
            return scanner.nextInt();
        }catch (Exception e) {
            throw new Exception("숫자만 입력이 가능합니다.");
        }
    }

    public static List<String> getManualNumber(int userManualCount) {
        List<String> userTickets = new ArrayList<>();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int index = 0; index < userManualCount; index++) {
            scanner = new Scanner(System.in);

            String userTicket = scanner.nextLine();
            userTickets.add(userTicket);
        }
        return userTickets;
    }

    public static int getTicketCount(int purchaseFee, int userManualCount) {
        int autoCount = (purchaseFee / TICKET_PRICE) - userManualCount;
        System.out.println("수동으로" + userManualCount + "장," + "자동으로" + autoCount + "장을 구매했습니다.");
        return autoCount;
    }

    public static String getWinningNumber() {
        // "1, 2, 3, 4, 5, 6"
        scanner = new Scanner(System.in);
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String getBonusNumber() {
        scanner = new Scanner(System.in);
        System.out.println("\n보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }
}