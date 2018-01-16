package lotto.domain;

import java.util.List;

public class LottoManualTicketRequest {
    private List<String> ticketRequests;

    public LottoManualTicketRequest(List<String> ticketRequests) {
        this.ticketRequests = ticketRequests;
    }

    public List<String> getTicketRequests() {
        return ticketRequests;
    }
}
