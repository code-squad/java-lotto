import domain.LottoFactory;
import domain.Lottos;
import dto.ResultDto;
import view.InputView;
import view.OutputView;

public class Main {
    public static void main(String[] args) {
        int price = InputView.purchaseAmount();
        int handCount = InputView.handMakeottosCount();
        Lottos handMakeLottos = InputView.handMakeLottos(handCount);
        ResultDto resultDto = new ResultDto(price, handCount, handMakeLottos);
        Lottos autoMakeLottos = LottoFactory.autoMakeLottos(resultDto.autoMakeLottoCount());
        OutputView outputView = new OutputView();
        outputView.printLottoCount(handCount, autoMakeLottos);
        resultDto.checkLastWinningNumbers(InputView.lastAnswerNumbers(), InputView.bonusBall(), autoMakeLottos);
        outputView.printResult(resultDto);
    }
}
