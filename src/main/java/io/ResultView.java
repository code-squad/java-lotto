package io;

import domain.Lotto;
import domain.Ticket;
import enums.Menu;
import utils.Utils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hoon on 2018. 1. 13..
 */
public class ResultView {
    public static void printResult(Lotto lotto) {

        System.out.print("당첨 통계");
        System.out.println("---------");

        System.out.printf("3개 일치 (5000원)- %d개\n", Menu.findMenu(3));
        System.out.printf("4개 일치 (50000원)- %d개\n", Menu.findMenu(4));
        System.out.printf("5개 일치 (1500000원)- %d개\n", Menu.findMenu(5));
        System.out.printf("6개 일치 (2000000000원)- %d개\n", Menu.findMenu(6));

        System.out.printf("총 수익률은 %.0f%%입니다\n", (Utils.getEarningsRate(lotto.getTotalMoney(), Menu.getWinningMoney())));
        Menu.clear();
    }

    public static void printTickets(List<Ticket> tickets) {
        for(Ticket ticket : tickets) {
            StringBuilder builder = new StringBuilder();
            builder.append("[").append(ticket.getNumbers().getNumbers().stream().map(String::valueOf).collect(Collectors.joining(", "))).append("]");
            System.out.println(builder.toString());
        }
    }
}
