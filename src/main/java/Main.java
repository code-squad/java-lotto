import domain.LottoGame;
import dto.LottoDto;
import dto.ResultDto;
import dto.StrikeDto;
import utils.Rank;
import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.Map;

import static utils.LottoGameValues.LOTTO_PRICE;
import static utils.MathHandler.getLottoTicketNum;

public class Main {
    public static void main(String[] args) {
        int lottoTicketNum = getLottoTicketNum(InputView.inputPurchaseAmount());
        ResultView.showTicketAmount(lottoTicketNum);

        LottoGame lottoGame = new LottoGame();
        LottoDto lottoDto = lottoGame.generateLottos(lottoTicketNum);
        ResultView.showLottos(lottoDto);

        List<StrikeDto> strikeDtos;
        while (true) {
            try {
                strikeDtos = lottoGame.checkLottos(InputView.inputWinningLottoNum(), InputView.inputBonusNum());
                break;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        Map<Rank, Integer> gameResult = lottoGame.assignGameResult(strikeDtos);
        int profitRate = lottoGame.calculateProfitRate(gameResult, lottoTicketNum * LOTTO_PRICE);
        ResultView.showLottoResult(new ResultDto(gameResult, profitRate));
    }
}
