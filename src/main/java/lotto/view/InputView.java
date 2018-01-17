package lotto.view;

import lotto.domain.LottoManualTicketRequest;
import lotto.domain.LottoMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public int requestToInputTicketTotalPrice() {
        System.out.println(LottoMessage.REQUEST_TOTAL_PRICE);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String requestToInputLastWeekSuccessNumbers() {
        System.out.println(LottoMessage.REQUEST_LAST_WEEK_SUCCESS_NUMBER);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String requestToInputLastWeekBonusNumber() {
        System.out.println(LottoMessage.REQUEST_BONUS_NUMBER);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int requestToInputCountOfManualTicket() {
        System.out.println(LottoMessage.REQUEST_MANUAL_TICKET_COUNT);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public LottoManualTicketRequest requestToInputManualTickets(int manualTicketCount) {
        System.out.println(LottoMessage.REQUEST_MANUAL_NUMBERS);

        List<String> manualTicketRequests = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < manualTicketCount; i++) {
            manualTicketRequests.add(scanner.nextLine());
        }
        return new LottoManualTicketRequest(manualTicketRequests);
    }
}
