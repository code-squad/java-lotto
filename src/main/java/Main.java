import domain.LottoGame;
import dto.LottoDto;
import view.InputView;
import view.ResultView;

import static utils.MathHandler.getLottoTicketNum;

public class Main {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        int lottoTicketNum = getLottoTicketNum(purchaseAmount);
        ResultView.showTicketAmount(lottoTicketNum);

        LottoGame lottoGame = new LottoGame();
        LottoDto lottoDto = lottoGame.generateLottos(lottoTicketNum);
        ResultView.showLottos(lottoDto);

        int[] strikeNums = lottoGame.checkLottosNum(InputView.inputWinningLottoNum());
        ResultView.showLottoResult(lottoGame.makeResultDto(strikeNums, purchaseAmount));
    }
}
