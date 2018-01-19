import domain.LottoFactory;
import domain.Lottos;
import dto.ResultDto;
import view.InputView;
import view.OutputView;

public class Main {
    public static void main(String[] args) {
        int price = InputView.purchaseAmount();
        ResultDto resultDto = new ResultDto(price);
        Lottos lottos = LottoFactory.makeLottos(resultDto.countOfLotto());
        OutputView outputView = new OutputView();
        outputView.printLottoCount(lottos);
        resultDto.checkLastWinningNumbers(InputView.lastAnswerNumbers(), InputView.bonusBall(), lottos);
        outputView.printResult(resultDto);
    }
}
