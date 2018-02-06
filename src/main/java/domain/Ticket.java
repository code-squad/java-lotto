package domain;

import io.InputView;
import utils.Utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by hoon on 2018. 1. 13..
 */
public class Ticket {

    private List<Integer> numbers;

    public Ticket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Integer calculateHits(Ticket winningNumbers) {
        return ((int) winningNumbers.numbers.stream().filter(number -> numbers.contains(number)).count());
    }

    public static List<Ticket> generateAutoTickets(Integer ticketCount) {
        return IntStream.range(0, ticketCount)
                .mapToObj(index -> new Ticket(Utils.generateRandomNumbers(6)))
                .collect(Collectors.toList());
    }

    public static List<Ticket> generateManualTickets(Integer count) {
        return IntStream.range(0, count)
                .mapToObj(i -> toTicket(Utils.toIntegerList(InputView.readLottoNumbersByManual())))
                .collect(Collectors.toList());
    }

    private static Ticket toTicket(List<Integer> numbers) {
        return new Ticket(numbers);
    }

    public Boolean contains(Integer number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }
}
