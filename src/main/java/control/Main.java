package control;

import domain.GameResult;
import domain.Lotto;
import domain.LottoGame;
import domain.WinningLotto;
import dto.LottoDto;
import dto.ResultDto;
import view.ResultView;

import java.util.List;

import static domain.Lotto.LOTTO_PRICE;

public class Main {
    public static void main(String[] args) {
        int lottoTicketCount = LottoTicketControl.getLottoTicketCount();
        int manualLottoTicketCount = LottoTicketControl.getManualLottoTicketCount(lottoTicketCount);

        LottoGame lottoGame = new LottoGame();
        LottoDto lottoDto = lottoGame.generateLottos(lottoTicketCount, manualLottoTicketCount);

        ResultView.printKindsOfLottosCount(lottoTicketCount, manualLottoTicketCount);
        ResultView.showLottos(lottoDto);

        GameResult gameResult = lottoGame.checkLottos(WinningLottoControl.getWinningLotto(), lottoDto);
        int profitRate = gameResult.calculateProfitRate((double) (lottoTicketCount * LOTTO_PRICE));
        ResultView.showLottoResult(new ResultDto(gameResult.getGameResult(), profitRate));
    }
}
