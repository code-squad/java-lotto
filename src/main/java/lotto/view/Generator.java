package lotto.view;

import lotto.domain.Number;
import lotto.domain.RandomDrawer;
import lotto.domain.Ticket;
import lotto.domain.Utils;

import java.util.ArrayList;
import java.util.List;

public class Generator {

    public static List<Ticket> generateAutoTickets(String money, String manual) {
        List<Ticket> autoTickets = new ArrayList<>();
        int auto = Utils.calcNumberOfAuto(Parser.parseToInt(money), Parser.parseToInt(manual));
        for (int i = 0; i < auto; i++) {
            autoTickets.add(new Ticket(RandomDrawer.newInstance().drawNumber()));
        }
        return autoTickets;
    }

    public static List<Ticket> generateManualTickets(String numbers, String inputMoney) {
        List<Ticket> manualTickets = new ArrayList<>();

        List<List<Integer>> manual = Parser.parseToLottoFormat(numbers);
        int money = Parser.parseToInt(inputMoney);
        Utils.validateInput(manual, money);

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

    public static Ticket generateWinningTicket(String input) {
        List<Number> winningNumbers = new ArrayList<>();
        Utils.checkOneTicket(input);

        List<Integer> numbers = Parser.parseToIntegers(Parser.splitToNumberStrings(input));
        for (Integer number : numbers) {
            winningNumbers.add(new Number(number));
        }
        return new Ticket(winningNumbers);
    }

    public static Number generateBonusNumber(String number) {
        return new Number(Parser.parseToInt(number));
    }
}