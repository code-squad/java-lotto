package lotto;

import lotto.domain.LottoGame;
import lotto.domain.NotTypeLottoException;
import lotto.domain.dto.ResultDto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        LottoGame lottoGame = null;
        int price = 0;

        try{
            price = InputView.buyLotto();
            lottoGame = new LottoGame(price);
            ResultView.printBuyLotto(lottoGame.createDto());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            main(args);
        }

        while(true) {
            try{
                compareWinningLotto(lottoGame, price);
                break;
            } catch (NotTypeLottoException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void compareWinningLotto(LottoGame lottoGame, int price) throws NotTypeLottoException {
        if (lottoGame != null && price != 0) {
            ResultDto result = lottoGame.compare(InputView.getWinningNumber(), InputView.getWinningBonusNumber());
            ResultView.statisticsLottoWinnings(price, result);
        }
    }
}
