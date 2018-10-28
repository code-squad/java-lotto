import domain.Lotto;
import domain.LottoGame;
import dto.LottoDto;
import dto.ResultDto;
import utils.NumParser;
import utils.Rank;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static utils.LottoGameValues.LOTTO_PRICE;
import static utils.MathHandler.getLottoTicketNum;

public class Main {
    public static void main(String[] args) {
        int lottoTicketCount = getLottoTicketNum(InputView.inputPurchaseAmount());
        int manualLottoCount = InputView.inputManualLottoCount();

        List<Lotto> manualLottos = new ArrayList<>();
        while (true) {
            ResultView.requestManualLottoNum();
            manualLottos.clear();
            try {
                for (int i = 0; i < manualLottoCount; i++) {
                    Lotto lotto = new Lotto(NumParser.parse(InputView.inputManualLottoNum()));
                    manualLottos.add(lotto);
                }
                break;
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }

        ResultView.printKindsOfLottosCount(lottoTicketCount, manualLottoCount);
        LottoGame lottoGame = new LottoGame(manualLottos);
        LottoDto lottoDto = lottoGame.generateLottos(lottoTicketCount - manualLottoCount);
        ResultView.showLottos(lottoDto);

        Map<Rank, Integer> gameResult;
        while (true) {
            try {
                gameResult = lottoGame.checkLottos(InputView.inputWinningLottoNum(), InputView.inputBonusNum());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        int profitRate = lottoGame.calculateProfitRate(gameResult, (double) (lottoTicketCount * LOTTO_PRICE));
        ResultView.showLottoResult(new ResultDto(gameResult, profitRate));
    }
}
