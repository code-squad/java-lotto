package lotto.view;

import lotto.domain.Number;
import lotto.domain.RandomDrawer;
import lotto.domain.Ticket;

import java.util.ArrayList;
import java.util.List;

import static lotto.view.Parser.*;
import static lotto.view.WebParser.*;

public class ManualGenerator {

    private final List<List<Integer>> manual;

    ManualGenerator(String manual) {
        this.manual = parseToLottoInts(manual);
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



//---------------------------------------------------------------------------------------------------------------------------------------

    public static List<Ticket> generateManualTicket(int manual) {
        List<Ticket> manualTickets = new ArrayList<>();
        Output.printMessage("수동으로 구매할 번호를 입력해 주세요.");

        for (int i = 0; i < manual; i++) {
            List<Number> numbers = parseToNumberArray(splitInput(Input.takeInput()));
            manualTickets.add(new Ticket(numbers));
        }
        return manualTickets;
    }

    public static List<Ticket> generateAutoTicket(int auto) {
        List<Ticket> autoTickets = new ArrayList<>();
        for (int i = 0; i < auto; i++) {
            autoTickets.add(new Ticket(RandomDrawer.newInstance().drawNumber()));
        }
        return autoTickets;
    }

    public static Ticket generateWinningTicket(String[] num) {
        List<Number> numbers = parseToNumberArray(num);
        return new Ticket(numbers);
    }

    public static Number generateBonusNumber(int number) {
        return parseToNumber(number);
    }
}