import domain.LottoSystem;
import dto.LottosDto;
import dto.ResultDto;
import view.InputView;
import view.OutputView;

public class Main {
    public static void main(String[] args) {
        LottoSystem lottoSystem = new LottoSystem();
        LottosDto lottosDto = lottoSystem.makeLottos(InputView.purchaseAmount());
        OutputView outputView = new OutputView();
        outputView.printLottoCount(lottosDto);
        ResultDto resultDto = lottoSystem.checkLastWinningNumbers(InputView.lastAnswerNumbers());
        outputView.printResult(resultDto);
    }
}
