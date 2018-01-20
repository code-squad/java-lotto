package view;

import domain.Lottos;
import domain.Rank;
import dto.ResultDto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class OutputView {
    public void printLottoCount(Lottos lottos) {
        System.out.println(lottos);
    }

    public void printResult(ResultDto resultDto) {
        System.out.printf("총 수익률은 %d%%입니다.\n", resultDto.calRevenue());
        Rank[] ranks = Rank.values();
        Map<Rank, Integer> ranksCount = resultDto.getRanksCount();
        Arrays.stream(ranks)
                .sorted(new Comparator<Rank>() {
                    @Override
                    public int compare(Rank o1, Rank o2) {
                        return o1.compare(o2);
                    }
                })
                .forEach(rank -> System.out.println(rank.toString() + ranksCount.get(rank)));
    }
}
