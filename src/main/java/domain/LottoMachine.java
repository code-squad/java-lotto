package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoMachine {
    private int ticketCount;
    private List<List> lottoTickets;

    public LottoMachine(int ticketCount) {
        this.ticketCount = ticketCount;
        lottoTickets = new ArrayList<>();
        lottoTickets = getLottoTickets(ticketCount);
    }

    public List<List> getLottoTickets() {
        return this.lottoTickets;
    }

    public void getMatch(List<Integer> lastWinningNumber) {
        for (int index = 0; index < ticketCount; index++) {
            List<Integer> ticket = lottoTickets.get(index);
            LottoResult.isValid(countMatchedNumber(ticket, lastWinningNumber));
        }
    }

    public int countMatchedNumber(List<Integer> ticket, List<Integer> lastWinningNumber) {
        int matchedNumberCount = 0;
        for (Integer number : lastWinningNumber) {
            if (ticket.contains(number)) {
                matchedNumberCount++;
            }
        }
        return matchedNumberCount;
    }

    public List<Integer> getLottoTicket() {
        Random random = new Random();
        List<Integer> ticket = new ArrayList<>();
        while (ticket.size() < 6) {
            int randomNumber = random.nextInt(45);
            randomNumber++; // 0 ~ 44 보정
            if (ticket.contains(randomNumber)) {
                continue;
            }
            ticket.add(randomNumber);
        }
        ticket.sort(Integer::compareTo);
        System.out.println(ticket);
        return ticket;
    }

    public List<List> getLottoTickets(int ticketCount) {
        List<List> lottoTickets = new ArrayList<>();
        while (lottoTickets.size() < ticketCount) {
            lottoTickets.add(getLottoTicket());
        }
        return lottoTickets;
    }
}
