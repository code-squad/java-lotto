package lotto.domain;

import java.util.List;

public class CustomerLottoTickets {
    private List<LottoTicket> tickets;

    public CustomerLottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }

    public int count() {
        return tickets.size();
    }
}
