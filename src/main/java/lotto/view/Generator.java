package lotto.view;

import lotto.domain.Number;
import lotto.domain.RandomDrawer;
import lotto.domain.Ticket;

import java.util.ArrayList;
import java.util.List;

public class Generator {

    public static List<Ticket> generateAutoTickets(int auto) {
        List<Ticket> autoTickets = new ArrayList<>();
        for (int i = 0; i < auto; i++) {
            autoTickets.add(new Ticket(RandomDrawer.newInstance().drawNumber()));
        }
        return autoTickets;
    }

    public static List<Ticket> generateManualTickets(List<List<Integer>> manual) {
        List<Ticket> manualTickets = new ArrayList<>();
        for (List<Integer> integers : manual) {
            manualTickets.add(new Ticket(convertToNumbers(integers)));
        }
        return manualTickets;
    }

    private static List<Number> convertToNumbers(List<Integer> integers) {
        List<Number> numbers = new ArrayList<>();
        for (Integer number : integers) {
            numbers.add(new Number(number));
        }
        return numbers;
    }

    public static Ticket generateWinningTicket(List<Integer> input) {
        List<Number> winningNumbers = new ArrayList<>();
        for (Integer number : input) {
            winningNumbers.add(new Number(number));
        }
        return new Ticket(winningNumbers);
    }

    public static Number generateBonusNumber(int number) {
        return new Number(number);
    }
}