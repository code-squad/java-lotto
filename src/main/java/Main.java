import domain.GameResult;
import domain.Lotto;
import domain.LottoGame;
import domain.LottoRules;
import dto.LottoDto;
import dto.ResultDto;
import utils.MathHandler;
import utils.NumParser;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

import static utils.LottoGameValues.LOTTO_PRICE;

public class Main {
    public static void main(String[] args) {
        int lottoTicketCount = 0;
        int manualLottoCount = 0;
        try {
            lottoTicketCount = LottoRules.checkLottoTicketCount(MathHandler.getLottoTicketNum(InputView.inputPurchaseAmount()));
            manualLottoCount = LottoRules.checkManualLottoCount(lottoTicketCount, InputView.inputManualLottoCount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println();
            main(args);
        }

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
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        ResultView.printKindsOfLottosCount(lottoTicketCount, manualLottoCount);
        LottoGame lottoGame = new LottoGame(manualLottos);
        LottoDto lottoDto = lottoGame.generateLottos(lottoTicketCount - manualLottoCount);
        ResultView.showLottos(lottoDto);

        GameResult gameResult;
        while (true) {
            try {
                gameResult = lottoGame.checkLottos(InputView.inputWinningLottoNum(), InputView.inputBonusNum());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        int profitRate = gameResult.calculateProfitRate((double) (lottoTicketCount * LOTTO_PRICE));
        ResultView.showLottoResult(new ResultDto(gameResult.getGameResult(), profitRate));
    }
}
