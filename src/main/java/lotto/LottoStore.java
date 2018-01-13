package lotto;

import lotto.domain.CustomerLottoTickets;
import lotto.domain.LottoTicket;
import lotto.util.TicketNumberParser;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final int UNIT_PRICE = 1000;

    public static int countTicket(int amount) {
        validateAmount(amount);
        return amount / UNIT_PRICE;
    }

    private static void validateAmount(int amount) {
        if (amount % UNIT_PRICE != 0) {
            throw new IllegalArgumentException("amount is not proper");
        }
    }

    public static LottoTicket buyRandomTicket() {
        return new LottoTicket(LottoGenerator.randomNumbers());
    }

    public static CustomerLottoTickets buyRandomTickets(int count) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(buyRandomTicket());
        }
        return new CustomerLottoTickets(tickets);
    }

    public static LottoTicket buyExplicitTicket(String numbersString) {
        return new LottoTicket(TicketNumberParser.parse(numbersString));
    }
}
