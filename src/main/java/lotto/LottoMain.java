package lotto;

import lotto.domain.LottoGame;
import lotto.domain.NotTypeLottoException;
import lotto.dto.InputDto;
import lotto.dto.ResultDto;
import lotto.view.BelowLimitMoneyException;
import lotto.view.InputTypeException;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        LottoGame lottoGame = null;

        try{
            InputDto inputDto = InputView.getInputData();
            lottoGame = new LottoGame(inputDto);
            ResultView.printBuyLotto(lottoGame.createDto());
        } catch (IllegalArgumentException | BelowLimitMoneyException | InputTypeException | NotTypeLottoException e) {
            System.out.println(e.getMessage());
            main(args);
        }

        while(true) {
            try{
                compareWinningLotto(lottoGame);
                break;
            } catch (NotTypeLottoException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void compareWinningLotto(LottoGame lottoGame) {
        ResultDto result = lottoGame.matchLotto(InputView.getWinningNumber(), InputView.getWinningBonusNumber());
        ResultView.statisticsLottoWinnings(result);
    }
}
