package lotto.view;

import lotto.domain.RandomDrawer;
import lotto.domain.Ticket;

import java.util.ArrayList;
import java.util.List;

public class AutoGenerator {
    private final int auto;

    private AutoGenerator(int auto){
        this.auto = auto;
    }

    public static List<Ticket> getAutoTickets(int auto) {
        AutoGenerator generator = new AutoGenerator(auto);
        return generator.generateAutoTickets();
    }

    public List<Ticket> generateAutoTickets() {
        List<Ticket> autoTickets = new ArrayList<>();
        for (int i = 0; i < auto; i++) {
            autoTickets.add(new Ticket(RandomDrawer.newInstance().drawNumber()));
        }
        return autoTickets;
    }
}
