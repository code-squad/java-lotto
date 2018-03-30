package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Lotto.LOTTO_PRICE;

public class Result {
    private static final int THREE_MATCH = 3;
    private static final int FOUR_MATCH = 4;
    private static final int FIVE_MATCH = 5;
    private static final int SIX_MATCH = 6;
    private static final long FIRST_PRIZE = 2000000000;
    private static final long SECOND_PRIZE = 1500000;
    private static final long THIRD_PRIZE = 50000;
    private static final long FOURTH_PRIZE = 5000;
    private final int ticketsBought;
    private final Ticket winningTicket;
    private List<Integer> matchCounts;

    Result(List<Number> winningNums, List<Ticket> tickets) {
        this.ticketsBought = tickets.size();
        this.winningTicket = new Ticket(winningNums);
        this.matchCounts = compareTickets(tickets);
    }

    private List<Integer> compareTickets(List<Ticket> tickets) {
        matchCounts = new ArrayList<>();
        for (Ticket ticket : tickets) {
            matchCounts.add(ticket.countMatchInTicket(winningTicket));
        }
        return matchCounts;
    }

    private int countTotalMatch(int place) {
        return (int) matchCounts.stream().filter(count -> count.equals(place)).count();
    }

    public int countFirstPlace() {
        return countTotalMatch(SIX_MATCH);
    }

    public int countSecondPlace() {
        return countTotalMatch(FIVE_MATCH);
    }

    public int countThirdPlace() {
        return countTotalMatch(FOUR_MATCH);
    }

    public int countFourthPlace() {
        return countTotalMatch(THREE_MATCH);
    }

    public double calculateProfit(int first, int second, int third, int fourth) {
        double earnings = (double) ((first * FIRST_PRIZE) + (second * SECOND_PRIZE) + (third * THIRD_PRIZE) + (fourth * FOURTH_PRIZE));
        return (earnings / (ticketsBought * LOTTO_PRICE)) * 100;
    }
}