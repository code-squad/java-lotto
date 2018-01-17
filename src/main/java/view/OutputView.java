package view;

import domain.Lottos;
import dto.ResultDto;

public class OutputView {
    public void printLottoCount(Lottos lottos) {
        int size = lottos.size();
        System.out.printf("%d개를 구매했습니다.\n", size);
        for (int i = 0; i < size; i++) {
            System.out.println(lottos.get(i));
        }
    }

    public void printResult(ResultDto resultDto) {
        System.out.printf("총 수익률은 %d%%입니다.", resultDto.calRevenue());
        for (int i = 3; i <= 6; i++) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", i, resultDto.getWinningPrice().get(i), resultDto.getWinningCount().get(i));
        }
    }
}
