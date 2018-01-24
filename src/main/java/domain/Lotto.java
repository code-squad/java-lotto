package domain;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import enums.*;

import static constant.Constant.LOTTO_PRICE;

/**
 * Created by hoon on 2018. 1. 13..
 */
public class Lotto {

    private List<Ticket> tickets;
    private Ticket winningNumbers;
    private Integer totalMoney;
    private Integer bonusNumber;

    public Lotto(List<Ticket> tickets, Ticket winningNumbers, Integer bonusNumber) {
        this.tickets = tickets;
        this.winningNumbers = winningNumbers;
        this.totalMoney = calculateTotalMoney();
        this.bonusNumber = bonusNumber;
    }

    private Integer calculateTotalMoney() {
        return tickets.size() * LOTTO_PRICE;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public Stream<Ticket> matchedCount(Integer count) {
        return tickets.stream()
                .filter(ticket -> Objects.equals(ticket.calculateHits(winningNumbers), count));
    }

    public Integer matchedBonusCount(Integer baseCount) {
        return (int)matchedCount(baseCount)
                .filter(ticket -> ticket.isBonusHit(bonusNumber))
                .count();
    }

    public Integer getWinningMoney() {
        return Arrays.stream(Match.values())
                .mapToInt(value -> value.getMoney() * (int)matchedCount(value.getMatched()).count())
                .sum();
    }

    public static Integer getTicketCount(int money) {
        return money / LOTTO_PRICE;
    }

}