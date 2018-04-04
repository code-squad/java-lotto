package lotto.view;

import lotto.domain.Ticket;

import java.util.List;

public interface Generator {

    public abstract List<Ticket> generateTickets();
}
