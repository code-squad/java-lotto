package lotto;

import lotto.domain.LottoCustomerTicket;
import lotto.domain.LottoConstants;
import lotto.domain.LottoManualTicketRequest;
import lotto.domain.LottoTicket;
import lotto.util.TicketNumberParser;
import spark.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static int countTotalTicket(int amount) {
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

    public static LottoCustomerTicket buyRandomTickets(int count) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(buyRandomTicket());
        }
        return new LottoCustomerTicket(tickets);
    }

    public static LottoTicket buyExplicitTicket(String numbersString) {
        return new LottoTicket(TicketNumberParser.parse(numbersString));
    }

    public static int countRandomTicket(int ticketTotalPrice, int manualTicketCount) {
        int totalTicketCount = countTotalTicket(ticketTotalPrice);
        if (manualTicketCount > totalTicketCount) {
            throw new IllegalArgumentException("manualTicketCount is invalid. " +
                    "ticketTotalPrice=" + ticketTotalPrice + ", manualTicketCount=" + manualTicketCount);
        }
        return totalTicketCount - manualTicketCount;
    }

    public static LottoCustomerTicket buyExplicitTickets(LottoManualTicketRequest lottoManualTicketRequest) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (String plainTicket : lottoManualTicketRequest.getTicketRequests()) {
            if (StringUtils.isEmpty(plainTicket)) {
                continue;
            }
            tickets.add(buyExplicitTicket(plainTicket));
        }
        return new LottoCustomerTicket(tickets);
    }

    public static LottoCustomerTicket buyLottoTicket(int ticketTotalPrice, LottoManualTicketRequest lottoManualTicketRequest) {
        LottoCustomerTicket explicitTickets = LottoStore.buyExplicitTickets(lottoManualTicketRequest);
        int randomTotalCount = LottoStore.countRandomTicket(ticketTotalPrice, explicitTickets.getTickets().size());
        LottoCustomerTicket randomTickets = LottoStore.buyRandomTickets(randomTotalCount);
        return new LottoCustomerTicket(randomTickets, explicitTickets);
    }
}
