package lotto.domain.generation;

import lotto.domain.utils.Parser;
import lotto.domain.utils.Validator;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.utils.Validator.LOTTO_PRICE;

public class Generator {

    public static List<Ticket> generateAutoTickets(int manual, String money) {
        List<Ticket> autoTickets = new ArrayList<>();
        int total = Parser.parseToInt(money) / LOTTO_PRICE; //throws exception
        int auto = total - manual;

        for (int i = 0; i < auto; i++) {
            autoTickets.add(new Ticket(RandomDrawer.newInstance().drawNumber()));
        }
        return autoTickets;
    }

    public static List<Ticket> generateManualTickets(String numbers, String inputMoney) {
        List<Ticket> manualTickets = new ArrayList<>();

        if(numbers.length() == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> manual = Parser.parseToLottoFormat(numbers); //throws exception
        int money = Parser.parseToInt(inputMoney); //throws exception
        Validator.validateInput(manual, money); //throws exception

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

    public static Ticket generate
    WinningTicket(String input) {
        List<Number> winningNumbers = new ArrayList<>();
        Validator.checkOneTicket(input); //throws exception

        List<Integer> numbers = Parser.parseToIntegers(Parser.splitToNumberStrings(input)); //throws exception
        for (Integer number : numbers) {
            winningNumbers.add(new Number(number));
        }
        return new Ticket(winningNumbers);
    }

    public static Number generateBonusNumber(String number) {
        return new Number(Parser.parseToInt(number));
    }
}