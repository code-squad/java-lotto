package lotto.view;

import lotto.domain.RandomDrawer;
import lotto.domain.Ticket;

import java.util.ArrayList;
import java.util.List;

public class AutoGenerator {
    private final int auto;

    AutoGenerator(int auto){
        this.auto = auto;
    }

    public List<Ticket> generateAutoTickets() {
        List<Ticket> autoTickets = new ArrayList<>();
        for (int i = 0; i < auto; i++) {
            autoTickets.add(new Ticket(RandomDrawer.newInstance().drawNumber()));
        }
        return autoTickets;
    }
}
