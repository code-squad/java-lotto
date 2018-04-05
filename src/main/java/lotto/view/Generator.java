package lotto.view;

import lotto.domain.Number;
import lotto.domain.RandomDrawer;
import lotto.domain.Ticket;
import lotto.domain.Utils;

import java.util.ArrayList;
import java.util.List;

public class Generator {

    public static List<Ticket> generateAutoTickets(String money, int manual) {
        List<Ticket> autoTickets = new ArrayList<>();
        int auto = Utils.calcNumberOfManual(Parser.parseToInt(money), manual);
        for (int i = 0; i < auto; i++) {
            autoTickets.add(new Ticket(RandomDrawer.newInstance().drawNumber()));
        }
        return autoTickets;
    }

    public static List<Ticket> generateManualTickets(String numbers, int money) throws IllegalArgumentException {
        List<Ticket> manualTickets = new ArrayList<>();
        List<List<Integer>> manual = Parser.parseToLottoFormat(numbers);

        if (Utils.isNotEnoughMoney(money)) {
            throw new IllegalArgumentException("최소 1000원 입니다.");
        }
        if (Utils.isNotValidMoney(money)) {
            throw new IllegalArgumentException("1000원 단위만 가능합니다.");
        }
        if (Utils.isOverPurchaseAmount(manual, money)) {
            throw new IllegalArgumentException("총 로또 수보다 많습니다.");
        }

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
        List<Integer> numbers = Parser.parseToIntegers()
        for (Integer number : input) {
            winningNumbers.add(new Number(number));
        }
        return new Ticket(winningNumbers);
    }

    public static Number generateBonusNumber(int number) {
        return new Number(number);
    }
}