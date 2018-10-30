package control;

import domain.GameResult;
import domain.Lotto;
import domain.LottoGame;
import dto.LottoDto;
import dto.ResultDto;
import view.ResultView;

import java.util.List;

import static utils.LottoGameValues.LOTTO_PRICE;

public class Main {
    public static void main(String[] args) {
        int lottoTicketCount = LottoTicketControl.getLottoTicketCount();
        int manualLottoTicketCount = LottoTicketControl.getManualLottoTicketCount(lottoTicketCount);
        List<Lotto> manualLottos = LottoControl.getManualLottos(manualLottoTicketCount);

        ResultView.printKindsOfLottosCount(lottoTicketCount, manualLottoTicketCount);
        LottoGame lottoGame = new LottoGame(manualLottos);
        LottoDto lottoDto = lottoGame.generateLottos(lottoTicketCount - manualLottoTicketCount);
        ResultView.showLottos(lottoDto);

        GameResult gameResult = LottoCheckControl.getLottoResult(lottoGame);
        int profitRate = gameResult.calculateProfitRate((double) (lottoTicketCount * LOTTO_PRICE));
        ResultView.showLottoResult(new ResultDto(gameResult.getGameResult(), profitRate));
    }
}
