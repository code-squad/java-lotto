package lottogame.view;

import lombok.extern.slf4j.Slf4j;
import lottogame.*;
import lottogame.util.LottoUtils;

import java.util.List;
import java.util.Scanner;

/**
 * Created by hongjong-wan on 2018. 4. 8..
 */
@Slf4j
public class ConsoleMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            int money = ConsoleInputView.getMoney(sc);
            int lottoTicketNumber = LottoUtils.getLottoTicketNumber(money);


            int manualLottoCount = ConsoleInputView.getManualLottoCount(sc);

            if (manualLottoCount < 0) {
                throw new IllegalArgumentException("수동으로 구매할 로또 수는 양수만 입력이 가능합니다.");
            }

            int autoLottoCount = lottoTicketNumber - manualLottoCount;

            LottoGame lottoGame = new LottoGame();
            for (int i = 0; i < manualLottoCount; i++) {
                lottoGame.createManualLotto(ConsoleInputView.getManualLottoNumber(sc));
            }
            lottoGame.createAutoLotto(autoLottoCount);
            ConsoleResultView.printPurchaseNumber(manualLottoCount, autoLottoCount);

            Lottos lottos = lottoGame.getLottos();
            ConsoleResultView.printLottos(lottos);

            WinningLotto winningLotto = new WinningLotto(ConsoleInputView.getWinningNumber(sc));
            winningLotto.addBonusNumber(new LottoNo(ConsoleInputView.getBonusNumber(sc)));

            List<Result> results = lottoGame.getRankResults(winningLotto);
            int yield = lottoGame.getYield(results, money);
            ConsoleResultView.printResult(results, yield);

        } catch (NumberFormatException e) {
            log.error("숫자를 입력해주세요.");
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage());
        }
    }
}