package lotto.domain;

import lotto.view.Input;
import lotto.view.UserPrompt;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Parser.*;
import static lotto.view.UserPrompt.*;

public class TicketGenerator {

    private static List<Ticket> getManualTickets() {
        List<Ticket> manualTickets = new ArrayList<>();
        int manual = getNumberOfManual(getTotalNumberOfTickets());

        for (int i = 0; i < manual; i++) {
            List<Number> manualNumbers = parseToNumberArray(splitString(Input.takeInput()));
            manualTickets.add(new Ticket(manualNumbers));
        }
        return manualTickets;
    }

    private List<Ticket> generateAutoTickets(int automatic) {
        List<Ticket> autoTickets = new ArrayList<>();
        for (int i = 0; i < automatic; i++) {
            autoTickets.add(new Ticket(RandomDrawer.newInstance().drawNumber()));
        }
        return autoTickets;
    }
}
