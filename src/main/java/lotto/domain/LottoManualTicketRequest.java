package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class LottoManualTicketRequest {
    private List<String> ticketRequests;

    public LottoManualTicketRequest(String ticketRequestsWithNewLine) {
        this.ticketRequests = Arrays.asList(ticketRequestsWithNewLine.split(LottoConstants.NEW_LINE));
    }

    public LottoManualTicketRequest(List<String> ticketRequests) {
        this.ticketRequests = ticketRequests;
    }

    public List<String> getTicketRequests() {
        return ticketRequests;
    }
}
