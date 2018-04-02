package domain;

import java.util.*;

public class LottoMain {
    public static int getPurchaseFee() {
        Scanner scanner = new Scanner("10000");
        return scanner.nextInt();
    }

    public static int getTicketCount(int purchaseFee) {
        return purchaseFee / 1000;
    }

    public static List getLottoTicket() {
        Random random = new Random();
         // 0 ~ 44
        List<Integer> ticket = new ArrayList<>();
        while (ticket.size() < 6) {
            int randomNumber = random.nextInt(45);
            if (ticket.contains(randomNumber)) {
                continue;
            }
            ticket.add(randomNumber);
        }
        ticket.sort(Integer::compareTo);
        System.out.println(ticket);
        return ticket;
    }

    public static List getLottoTickets(int ticketCount) {
        List<List> lottoTickets = new ArrayList<>();
        while (lottoTickets.size() < ticketCount) {
            lottoTickets.add(getLottoTicket());
        }
        System.out.println(lottoTickets);
        return lottoTickets;
    }
}
