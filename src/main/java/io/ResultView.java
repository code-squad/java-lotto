package io;

import domain.Lotto;
import domain.Ticket;
import enums.Rank;
import utils.Utils;

import java.util.List;

/**
 * Created by hoon on 2018. 1. 13..
 */
public class ResultView {
    public static void printResult(Lotto lotto) {

        System.out.print("당첨 통계");
        System.out.println("---------");

        System.out.printf("3개 일치 (%d원)- %d개\n", Rank.FIFTH.getMoney(), lotto.matchedCount(Rank.FIFTH));
        System.out.printf("4개 일치 (%d원)- %d개\n", Rank.FOURTH.getMoney(), lotto.matchedCount(Rank.FOURTH));
        System.out.printf("5개 일치 (%d원)- %d개\n", Rank.THIRD.getMoney(), lotto.matchedCount(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치(%d원)- %d개\n", Rank.SECOND.getMoney(), lotto.matchedCount(Rank.SECOND));
        System.out.printf("6개 일치 (%d원)- %d개\n", Rank.FIRST.getMoney(), lotto.matchedCount(Rank.FIRST));

        System.out.printf("총 수익률은 %.0f%%입니다\n", Utils.getEarningsRate(lotto.getTotalMoney(), lotto.getWinningMoney()));
    }

    public static void printTickets(List<Ticket> tickets) {
        for(Ticket ticket : tickets) {
            StringBuilder builder = new StringBuilder();
            builder.append("[").append(ticket.toString()).append("]");
            System.out.println(builder.toString());
        }
    }
}
