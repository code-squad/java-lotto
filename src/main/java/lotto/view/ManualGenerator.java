package lotto.view;

import lotto.domain.Number;
import lotto.domain.Ticket;

import java.util.ArrayList;
import java.util.List;

import static lotto.view.WebParser.*;

public class ManualGenerator implements Generator {
    private final List<List<Integer>> manual;

    public ManualGenerator(List<List<Integer>> manual) {
        this.manual = manual;
    }

    public List<Ticket> generateTickets() {
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

//    public static Ticket generateWinningTicket(String input) {
//        List<Number> winningNumbers = new ArrayList<>();
//
//        List<Integer> numbers = parseToIntegers(splitToNumberStrings(input));
//        for (Integer number : numbers) {
//            winningNumbers.add(new Number(number));
//        }
//        return new Ticket(winningNumbers);
//    }

    public static Number generateBonusNumber(int number) {
        return new Number(number);
    }
}