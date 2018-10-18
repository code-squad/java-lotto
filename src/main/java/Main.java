import domain.LottoGame;
import dto.LottoDto;
import view.InputView;
import view.ResultView;

import static utils.MathHandler.getLottoTicketNum;

public class Main {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        ResultView.showTicketAmount(getLottoTicketNum(purchaseAmount));

        LottoGame lottoGame = new LottoGame();
        LottoDto lottoDto = lottoGame.makeLottoDto(getLottoTicketNum(purchaseAmount));
        ResultView.showLottos(lottoDto);

        int[] matchPoint = lottoGame.checkLotto(InputView.inputWinningNums());
        ResultView.showResult(lottoGame.makeResultDto(matchPoint, purchaseAmount));
    }
}
