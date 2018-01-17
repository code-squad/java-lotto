package view;

import domain.Lotto;
import dto.LottosDto;
import dto.ResultDto;

import java.util.List;

public class OutputView {
    public void printLottoCount(LottosDto lottosDto) {
        List<Lotto> lottos = lottosDto.getLottos();
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printResult(ResultDto resultDto) {
        System.out.printf("총 수익률은 %d%%입니다.", resultDto.getRevenue());
        for (int i = 3; i <= 6; i++) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", i, resultDto.getWinningPrice().get(i), resultDto.getWinningCount().get(i));
        }
    }
}
