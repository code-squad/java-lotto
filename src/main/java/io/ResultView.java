package io;

import domain.Lotto;
import domain.Ticket;
import enums.Match;
import utils.Utils;

import java.util.List;

import static constant.Constant.BONUS_MONEY;

/**
 * Created by hoon on 2018. 1. 13..
 */
public class ResultView {
    public static void printResult(Lotto lotto) {

        System.out.print("당첨 통계");
        System.out.println("---------");

        System.out.printf("3개 일치 (%d원)- %d개\n", Match.valueOf(3).getMoney(), lotto.matchedCount(3).count());
        System.out.printf("4개 일치 (%d원)- %d개\n", Match.valueOf(4).getMoney(), lotto.matchedCount(4).count());
        System.out.printf("5개 일치 (%d원)- %d개\n", Match.valueOf(5).getMoney(), lotto.matchedCount(5).count());
        System.out.printf("5개 일치, 보너스 볼 일치(%d원)- %d개\n", Match.valueOf(5).getMoney() + BONUS_MONEY, lotto.matchedBonusCount(5));
        System.out.printf("6개 일치 (%d원)- %d개\n", Match.valueOf(6).getMoney(), lotto.matchedCount(6).count());

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
