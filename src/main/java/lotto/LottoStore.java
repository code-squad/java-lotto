package lotto;

import lotto.domain.LottoCustomer;
import lotto.domain.LottoConstants;
import lotto.domain.LottoTicket;
import lotto.util.TicketNumberParser;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    public static int countTicket(int amount) {
        validateAmount(amount);
        return amount / LottoConstants.UNIT_PRICE;
    }

    private static void validateAmount(int amount) {
        if (amount % LottoConstants.UNIT_PRICE != 0) {
            throw new IllegalArgumentException("amount is not proper");
        }
    }

    public static LottoTicket buyRandomTicket() {
        return new LottoTicket(LottoGenerator.randomNumbers());
    }

    public static LottoCustomer buyRandomTickets(int count) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(buyRandomTicket());
        }
        return new LottoCustomer(tickets);
    }

    public static LottoTicket buyExplicitTicket(String numbersString) {
        return new LottoTicket(TicketNumberParser.parse(numbersString));
    }
}
