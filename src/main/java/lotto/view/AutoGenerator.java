package lotto.view;

import lotto.domain.RandomDrawer;
import lotto.domain.Ticket;

import java.util.ArrayList;
import java.util.List;

public class AutoGenerator implements Generator {
    private final int auto;

    public AutoGenerator(int auto) {
        this.auto = auto;
    }

    private List<Ticket> generateTickets() {
        List<Ticket> autoTickets = new ArrayList<>();
        for (int i = 0; i < auto; i++) {
            autoTickets.add(new Ticket(RandomDrawer.newInstance().drawNumber()));
        }
        return autoTickets;
    }
}