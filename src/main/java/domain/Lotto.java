package domain;

import enums.Menu;

import java.util.List;

import static constant.Constant.LOTTO_PRICE;

/**
 * Created by hoon on 2018. 1. 13..
 */
public class Lotto {

    List<Ticket> tickets;
    Numbers winningNumbers;
    Integer totalMoney;

    public Lotto(List<Ticket> tickets, Numbers winningNumbers) {
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

    public Lotto lottery() {
        for(Ticket ticket : tickets) {
            ticket.calculateHits(winningNumbers);
            Menu.renewHits(ticket.getHits());
        }
        return this;
    }
}

