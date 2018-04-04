package lotto.view;

import lotto.domain.Number;
import lotto.domain.Ticket;

import java.util.ArrayList;
import java.util.List;

import static lotto.view.WebParser.*;

public class ManualGenerator {
    private final List<List<Integer>> manual;

    private ManualGenerator(String manual) {
        this.manual = parseToLottoInts(manual);
    }

    public static List<Ticket> getManualTickets(String manual) {
        ManualGenerator generator = new ManualGenerator(manual);
        return generator.generateTickets();
    }

    private List<Ticket> generateTickets() {
        List<Ticket> manualTickets = new ArrayList<>();
        for (List<Integer> integers : manual) {
            manualTickets.add(new Ticket(convertToNumbers(integers)));
        }
        return manualTickets;
    }

    private List<Number> convertToNumbers(List<Integer> integers) {
        List<Number> numbers = new ArrayList<>();
        for (Integer number : integers) {
            numbers.add(new Number(number));
        }
        return numbers;
    }

    public static Ticket generateWinningTicket(List<String> numbers) { //check input format
        List<Number> winningNumbers = new ArrayList<>();
        for (String number : numbers) {
            winningNumbers.add(new Number(Integer.parseInt(number)));
        }
        return new Ticket(winningNumbers);
    }

    public static Number generateBonusNumber(int number) { //check input format
        return new Number(number);
    }
}
