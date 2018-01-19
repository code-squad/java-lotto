package view;

import domain.Lottos;
import domain.Rank;
import dto.ResultDto;

import java.util.Map;

public class OutputView {
    public void printLottoCount(Lottos lottos) {
        int size = lottos.size();
        System.out.printf("%d개를 구매했습니다.\n", size);
        for (int i = 0; i < size; i++) {
            System.out.println(lottos.get(i));
        }
    }

    public void printResult(ResultDto resultDto) {
        System.out.printf("총 수익률은 %d%%입니다.\n", resultDto.calRevenue());
        Rank[] ranks = Rank.values();
        Map<Rank, Integer> ranksCount = resultDto.getRanksCount();
        for (int i = ranks.length - 1; i >= 0; i--) {
            System.out.println(ranks[i].toString() + ranksCount.get(ranks[i]));
        }
    }
}
