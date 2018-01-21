package domain;

import enums.Match;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static constant.Constant.LOTTO_PRICE;

/**
 * Created by hoon on 2018. 1. 13..
 */
public class Lotto {

    private List<Ticket> tickets;
    private Ticket winningNumbers;
    private Integer totalMoney;

    public Lotto(List<Ticket> tickets, Ticket winningNumbers) {
        this.tickets = tickets;
        this.winningNumbers = winningNumbers;
        this.totalMoney = calculateTotalMoney();
    }

    private Integer calculateTotalMoney() {
        return tickets.size() * LOTTO_PRICE;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public Integer matchedCount(Integer count) {
        return (int)tickets.stream().filter(ticket -> Objects.equals(ticket.calculateHits(winningNumbers), count)).count();
    }

    public Integer getWinningMoney() {
        return Arrays.stream(Match.values())
                .mapToInt(value -> value.getMoney() * matchedCount(value.getMatched()))
                .sum();
    }

    public static Integer getTicketCount(int money) {
        return money / LOTTO_PRICE;
    }

}