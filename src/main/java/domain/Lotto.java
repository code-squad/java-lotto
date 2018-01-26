package domain;


import enums.Rank;

import java.util.Arrays;
import java.util.List;

import static constant.Constant.LOTTO_PRICE;

/**
 * Created by hoon on 2018. 1. 13..
 */
public class Lotto {

    private List<Ticket> tickets;
    private WinningTicket winningTicket;
    private Integer totalMoney;

    public Lotto(List<Ticket> tickets, WinningTicket winningTicket) {
        this.tickets = tickets;
        this.winningTicket = winningTicket;
        this.totalMoney = calculateTotalMoney();
    }

    private Integer calculateTotalMoney() {
        return tickets.size() * LOTTO_PRICE;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public Integer matchedCount(Rank rank) {
        return (int)tickets.stream()
                .filter(ticket -> winningTicket.match(ticket).equals(rank))
                .count();
    }


    public Integer getWinningMoney() {
        return Arrays.stream(Rank.values())
                .mapToInt(rank -> rank.getMoney() * matchedCount(rank))
                .sum();
    }

    public static Integer getTicketCount(int money) {
        return money / LOTTO_PRICE;
    }

}