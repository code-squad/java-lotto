package lotto.domain;

import java.util.ArrayList;
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

    public static List<LottoTicket> issue(int pay) {
        List<LottoTicket> tickets = new ArrayList<>();
        IntStream.range(0, getPurchasableTicketCount(pay))
                .forEach(x -> tickets.add(issue()));
        
        return tickets;
    }

    static int getTicketPrice() {
        return TICKET_PRICE;
    }

    static int getPurchasableTicketCount(int pay) {
        return pay / TICKET_PRICE;
    }

    private static void shuffle() {
        Collections.shuffle(range);
    }
}
