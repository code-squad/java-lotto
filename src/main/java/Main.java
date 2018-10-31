import domain.Lotto;
import domain.Lottos;
import domain.LottosFactory;
import domain.Statistic;
import dto.LottoDto;
import dto.LottosDto;
import dto.StatisticDto;
import util.Parser;

import java.util.List;

import static view.InputView.*;
import static view.ResultView.*;

public class Main {
    static final int PRICE_OF_LOTTO_TICKET = 1000;

    public static void main(String[] args) {
        //구입금액 입력
        int purchasePrice = purchasePrice();
        List<Lotto> massLotto = LottosFactory.makeLottos(purchasePrice / PRICE_OF_LOTTO_TICKET);
        Lottos lottos = new Lottos(massLotto);
        LottosDto lottosDto = lottos.toDto();

        //모든 로또 목록 출력
        printLottos(lottosDto);

        //당첨 번호 입력
        Lotto winnerLotto = new Lotto(Parser.makeWinnerLotto(WinnerLottoNumber()));
        LottoDto winnerLottoDto = winnerLotto.toDto();

        //당첨 통계 출력
        Statistic statistic = new Statistic(massLotto);
        statistic.checkLottoRank(winnerLotto);
        StatisticDto statisticDto = statistic.toDto();
        printResult(statisticDto.getWinnerInfo(), purchasePrice);

//        int purchasePrice = purchasePrice();
//        List<Lotto> lottos = LottosFactory.makeLottos(purchasePrice / PRICE_LOTTO_TICKET);
//        printLottos(lottos);
//        Lotto winnerLotto = new Lotto(Parser.makeWinnerLotto(WinnerLottoNumber()));
//        Statistic statistic = new Statistic(lottos);
//        printResult(statistic.checkLottoRank(winnerLotto), purchasePrice);
    }
}
