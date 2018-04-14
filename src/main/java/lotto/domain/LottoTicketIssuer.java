package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketIssuer {
    private static final int TICKET_PRICE = 1_000;
    
    private static final List<Integer> range = IntStream.rangeClosed(1, 45)
            .boxed().collect(Collectors.toList());

    private LottoTicketIssuer() { }

    public static LottoTicket issue() {
        shuffle();
        return new LottoTicket(range.subList(0, 6));
    }

    public static LottoTicket issue(List<Integer> numbers) {
        return new LottoTicket(numbers);
    }

    public static List<LottoTicket> issue(int pay) {
        List<LottoTicket> tickets = new ArrayList<>();
        IntStream.range(0, getPurchasableTicketCount(pay))
                .forEach(x -> tickets.add(issue()));
        
        return tickets;
    }

    public static LottoTicket issue(String numbers) {
        return issue(toList(numbers));
    }

    public static List<LottoTicket> issue(String[] numbers) {
        return Arrays.stream(numbers)
                    .map(number -> issue(toList(number)))
                    .collect(Collectors.toList());
    }

    public static int getTicketPrice() {
        return TICKET_PRICE;
    }

    public static int getTicketPrice(int ticketCount) {
        return getTicketPrice() * ticketCount;
    }

    public static int getPurchasableTicketCount(int pay) {
        return pay / TICKET_PRICE;
    }

    private static void shuffle() {
        Collections.shuffle(range);
    }

    private static List<Integer> toList(String numbersText) {
        return Arrays.stream(parseInts(split(numbersText)))
                .boxed()
                .collect(Collectors.toList());
    }

    private static String[] split(String text) {
        return text.split(",");
    }

    private static int[] parseInts(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
